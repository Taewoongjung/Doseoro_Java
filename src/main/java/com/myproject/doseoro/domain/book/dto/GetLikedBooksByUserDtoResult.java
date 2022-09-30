package com.myproject.doseoro.domain.book.dto;

import com.myproject.doseoro.domain.book.vo.BookVO;
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
