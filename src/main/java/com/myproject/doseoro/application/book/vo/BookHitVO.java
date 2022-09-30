package com.myproject.doseoro.application.book.vo;

import lombok.*;

@Getter
@ToString
public class BookHitVO {
    private String id;
    private final String userId;
    private final String bookId;
    private String isLiked;

    public BookHitVO(String id, String userId, String bookId, String isLiked) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isLiked = isLiked;
    }

    public void imbueId(String id) {
        this.id = id;
    }
}
