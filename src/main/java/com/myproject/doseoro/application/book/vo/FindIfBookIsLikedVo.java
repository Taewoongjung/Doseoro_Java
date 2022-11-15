package com.myproject.doseoro.application.book.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class FindIfBookIsLikedVo {

    private final String userId;
    private final String bookId;
}
