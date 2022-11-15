package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
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
        GetAllInformationOfTheBookByBookIdDto detailDTO) {

        BookVO book = bookMybatisService.findBookByBookId(detailDTO.getBookId());
        IdentityMyPageVO user = repository.findUserById(book.getOwnerId());
        String userId = accessUserSessionManager.extractUser();

        List<BookHitVO> countLikedInTheBook = bookMybatisService.countLike(detailDTO.getBookId());

        // 이 페이지를 열어본 유저가 책에 좋아요를 눌렀는지 검사 (여부에 따라 하트 색깔 바뀜)
        String isLikeExisted = bookMybatisService.isBookLiked(
            new FindIfBookIsLikedVo(userId, detailDTO.getBookId())
        );

        return new GetAllInformationOfTheBookByBookIdDtoResult(
            book, user, countLikedInTheBook, isLikeExisted
        );
    }
}
