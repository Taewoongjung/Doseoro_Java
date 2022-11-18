package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetAllInformationOfTheBookByBookIdDtoResult {

    private final BookVO book;
    private final List<BookHitVO> countLikedInTheBook;
    private final String isLikeExisted;
}
