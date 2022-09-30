package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllSaleBooksResult {
    private final List<FindAllBooksVO> bookList;

    public GetAllSaleBooksResult(List<FindAllBooksVO> bookList) {
        this.bookList = bookList;
    }
}
