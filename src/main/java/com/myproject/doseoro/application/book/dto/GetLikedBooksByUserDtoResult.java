package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.BookVO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@RequiredArgsConstructor
public class GetLikedBooksByUserDtoResult {
    private final List<BookVO> likedBooks;
}
