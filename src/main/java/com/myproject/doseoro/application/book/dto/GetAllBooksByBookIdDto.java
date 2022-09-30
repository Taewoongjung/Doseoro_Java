package com.myproject.doseoro.application.book.dto;

import lombok.Getter;

@Getter
public class GetAllBooksByBookIdDto {
    private final String bookId;

    public GetAllBooksByBookIdDto(String bookId) {
        this.bookId = bookId;
    }
}
