package com.myproject.doseoro.domain.book.dto;

import lombok.Getter;

@Getter
public class BookDetailDto {
    private final String bookId;

    public BookDetailDto(String bookId) {
        this.bookId = bookId;
    }
}
