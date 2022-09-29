package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.dto.BookDetailDto;
import com.myproject.doseoro.domain.book.dto.BookDetailDtoResult;
import com.myproject.doseoro.domain.book.vo.BookHitVO;
import com.myproject.doseoro.domain.book.vo.BookVO;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDetailPageQuery implements CommandQuery<BookDetailDto, BookDetailDtoResult> {
    private final BookMybatisRepository bookMybatisService;
    private final IdentityMybatisRepository repository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Override
    public BookDetailDtoResult query(BookDetailDto detailDTO) {
        BookVO book = bookMybatisService.findBookByBookId(detailDTO.getBookId());
        IdentityMyPageVO user = repository.findUserById(book.getOwnerId());
        String userId = accessUserSessionManager.extractUser();

        List<BookHitVO> countLikedInTheBook = bookMybatisService.countLike(detailDTO.getBookId());
        String isLikeExisted = bookMybatisService.isBookLiked(userId, detailDTO.getBookId());

        return new BookDetailDtoResult(book, user, countLikedInTheBook, isLikeExisted);
    }
}
