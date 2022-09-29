package com.myproject.doseoro.domain.book.dto;

import com.myproject.doseoro.domain.book.vo.FindAllBooksVO;
import lombok.Getter;

import java.util.List;

@Getter
public class SaleBoardDtoResult {
    private final List<FindAllBooksVO> bookList;

    public SaleBoardDtoResult(List<FindAllBooksVO> bookList) {
        this.bookList = bookList;
    }
}
