package com.myproject.doseoro.application.book.vo;

import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookHitVO {

    private final String userId;
    private final String bookId;
    private String id;
    private String isLiked;

    public BookHitVO(String id, String userId, String bookId, String isLiked) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.isLiked = isLiked;
    }

    public void imbueId() {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
    }

    public boolean checkIdExisted() {
        if (this.id.isBlank()) {
            return false;
        }
        return true;
    }

    public boolean checkIsLiked() {
        if (this.isLiked.equals("t")) {
            return false;
        }
        return true;
    }
}
