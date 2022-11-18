package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetAllInformationOfBuyingBookByBookIdDtoResult {

    private final BookVO book;
    private final IdentityMyPageVO user;
    private final List<BookHitVO> countLikedInTheBook;
    private final String isLikeExisted;
}
