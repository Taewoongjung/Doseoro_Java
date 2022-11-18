package com.myproject.doseoro.application.book.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class HomeDisplayedBuyingBookVO {

    private String id;
    private String postMessage;
    private String userNickName;
    private String about;

    public HomeDisplayedBuyingBookVO(
        final String id,
        final String postMessage,
        final String userNickName,
        final String about
    ) {
        this.id = id;
        this.postMessage = postMessage;
        this.userNickName = userNickName;
        this.about = about;
    }
}
