package com.myproject.doseoro.application.book.dto;

import lombok.Getter;

@Getter
public class GetAllInformationOfTheBookByBookIdDto {
    private final String bookId;

    public GetAllInformationOfTheBookByBookIdDto(String bookId) {
        this.bookId = bookId;
    }
}
