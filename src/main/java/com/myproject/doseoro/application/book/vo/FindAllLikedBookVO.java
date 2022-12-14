package com.myproject.doseoro.application.book.vo;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class FindAllLikedBookVO {

    private final String id;
    private final String postMessage;
    private final String title;
    private final String price;
    private final String author;
    private final String publisher;
    private final List<String> category;
    private final List<String> state;
    private final String tradeMethod;
    private final List<String> images;
    private final String likeCount;
    private final String sold;
    private final String about;
    private final String OwnerId;
}
