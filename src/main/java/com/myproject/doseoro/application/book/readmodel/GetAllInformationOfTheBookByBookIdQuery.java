package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllInformationOfTheBookByBookIdQuery implements
    CommandQuery<GetAllInformationOfTheBookByBookIdDto, GetAllInformationOfTheBookByBookIdDtoResult> {

    private final BookRepository bookMybatisService;
    private final IdentityRepository repository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Logging
    @Override
    public GetAllInformationOfTheBookByBookIdDtoResult query(
        GetAllInformationOfTheBookByBookIdDto book) {

        BookVO foundBook = findBookByBookId(book.getBookId());
        String userId = getUserIdFromSession();
        List<BookHitVO> countLikedOfTheBook = getLikedCountOfTheBook(book.getBookId());

        // 이 페이지를 열어본 유저가 책에 좋아요를 눌렀는지 검사 (여부에 따라 하트 색깔 바뀜)
        String isLikeExistedInTheBookPage = isBookLiked(userId, book.getBookId());

        return new GetAllInformationOfTheBookByBookIdDtoResult(
            foundBook, countLikedOfTheBook, isLikeExistedInTheBookPage
        );
    }

    private BookVO findBookByBookId(String bookId) {
        return bookMybatisService.findBookByBookId(bookId);
    }

    private String getUserIdFromSession() {
        return accessUserSessionManager.extractUser();
    }

    private List<BookHitVO> getLikedCountOfTheBook(String bookId) {
        return bookMybatisService.countLike(bookId);
    }

    private String isBookLiked(String userId, String bookId) {
        return bookMybatisService.isBookLiked(new FindIfBookIsLikedVo(userId, bookId));
    }
}
