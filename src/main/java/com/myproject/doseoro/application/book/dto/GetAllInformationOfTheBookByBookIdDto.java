package com.myproject.doseoro.application.book.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetAllInformationOfTheBookByBookIdDto {

    private final String bookId;
}
