package com.myproject.doseoro.application.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@RequiredArgsConstructor
public class BookLikCountVO {

    private final String id;
    private final String userId;
    private final String bookId;
    private final String isLiked;
}
