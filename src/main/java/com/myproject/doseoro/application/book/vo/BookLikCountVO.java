package com.myproject.doseoro.application.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
public class BookLikCountVO {

    private String id;
    private String userId;
    private String bookId;
    private String isLiked;

    public BookLikCountVO(
        final String id,
        final String userId,
        final String bookId,
        final String isLiked
    ) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isLiked = isLiked;
    }
}
