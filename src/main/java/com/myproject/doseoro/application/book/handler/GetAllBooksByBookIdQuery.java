package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.abstraction.BookRepository;
import com.myproject.doseoro.domain.book.dto.GetAllBooksByBookIdDto;
import com.myproject.doseoro.domain.book.dto.GetAllBooksByBookIdDtoResult;
import com.myproject.doseoro.domain.book.vo.BookHitVO;
import com.myproject.doseoro.domain.book.vo.BookVO;
import com.myproject.doseoro.domain.identity.abstraction.IdentityRepository;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBooksByBookIdQuery implements CommandQuery<GetAllBooksByBookIdDto, GetAllBooksByBookIdDtoResult> {
    private final BookRepository bookMybatisService;
    private final IdentityRepository repository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Override
    public GetAllBooksByBookIdDtoResult query(GetAllBooksByBookIdDto detailDTO) {
        BookVO book = bookMybatisService.findBookByBookId(detailDTO.getBookId());
        IdentityMyPageVO user = repository.findUserById(book.getOwnerId());
        String userId = accessUserSessionManager.extractUser();

        List<BookHitVO> countLikedInTheBook = bookMybatisService.countLike(detailDTO.getBookId());
        String isLikeExisted = bookMybatisService.isBookLiked(userId, detailDTO.getBookId());

        return new GetAllBooksByBookIdDtoResult(book, user, countLikedInTheBook, isLikeExisted);
    }
}
