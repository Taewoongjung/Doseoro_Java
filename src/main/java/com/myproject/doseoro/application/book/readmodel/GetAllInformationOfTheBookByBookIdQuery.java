package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
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

    @Override
    public GetAllInformationOfTheBookByBookIdDtoResult query(
        GetAllInformationOfTheBookByBookIdDto allBook) {

        BookVO book = findBookByBookId(allBook.getBookId());
        IdentityMyPageVO user = findUserById(book.getOwnerId());
        String userId = getUserIdFromSession();
        List<BookHitVO> countLikedOfTheBook = getLikedCountOfTheBook(allBook.getBookId());

        // 이 페이지를 열어본 유저가 책에 좋아요를 눌렀는지 검사 (여부에 따라 하트 색깔 바뀜)
        String isLikeExistedInTheBookPage = isBookLiked(userId, allBook.getBookId());

        return new GetAllInformationOfTheBookByBookIdDtoResult(
            book, user, countLikedOfTheBook, isLikeExistedInTheBookPage
        );
    }

    private BookVO findBookByBookId(String bookId) {
        return bookMybatisService.findBookByBookId(bookId);
    }

    private IdentityMyPageVO findUserById(String userId) {
        return repository.findUserById(userId);
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
