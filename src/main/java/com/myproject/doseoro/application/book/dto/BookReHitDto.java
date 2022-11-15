package com.myproject.doseoro.application.book.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BookReHitDto {

    private final String userId;
    private final String bookId;
    private final String isLiked;
}
