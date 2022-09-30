package com.myproject.doseoro.application.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
public class AllLikedBookVO {

    private String id;
    private String userId;
    private String bookId;

    public AllLikedBookVO(final String id, final String userId, final String bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }
}
