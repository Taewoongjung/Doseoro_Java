package com.myproject.doseoro.domain.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
public class AllLikedBookVO {
    private String userId;
    private String bookId;

    public AllLikedBookVO(final String userId, final String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
}
