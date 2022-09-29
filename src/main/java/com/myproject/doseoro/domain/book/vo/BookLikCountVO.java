package com.myproject.doseoro.domain.book.vo;

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

    public BookLikCountVO(String id, String userId, String bookId, String isLiked) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isLiked = isLiked;
    }
}
