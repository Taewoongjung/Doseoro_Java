package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllInformationOfTheBookByBookIdDtoResult {
    private final BookVO book;

    public GetAllInformationOfTheBookByBookIdDtoResult(BookVO book, IdentityMyPageVO user, List<BookHitVO> countLikedInTheBook, String isLikeExisted) {
        this.book = book;
        this.user = user;
        this.countLikedInTheBook = countLikedInTheBook;
        this.isLikeExisted = isLikeExisted;
    }

    private final IdentityMyPageVO user;
    private final List<BookHitVO> countLikedInTheBook;
    private final String isLikeExisted;
}
