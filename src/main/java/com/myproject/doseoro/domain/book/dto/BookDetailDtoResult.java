package com.myproject.doseoro.domain.book.dto;

import com.myproject.doseoro.domain.book.vo.BookHitVO;
import com.myproject.doseoro.domain.book.vo.BookVO;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BookDetailDtoResult {
    private final BookVO book;

    public BookDetailDtoResult(BookVO book, IdentityMyPageVO user, List<BookHitVO> countLikedInTheBook, String isLikeExisted) {
        this.book = book;
        this.user = user;
        this.countLikedInTheBook = countLikedInTheBook;
        this.isLikeExisted = isLikeExisted;
    }

    private final IdentityMyPageVO user;
    private final List<BookHitVO> countLikedInTheBook;
    private final String isLikeExisted;
}
