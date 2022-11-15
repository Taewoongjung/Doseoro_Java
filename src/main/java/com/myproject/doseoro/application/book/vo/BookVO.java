package com.myproject.doseoro.application.book.vo;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BookVO {

    private String id;
    private String postMessage;
    private String title;
    private String price;
    private String author;
    private String publisher;
    private List<String> category;
    private List<String> state;
    private String tradeMethod;
    private List<String> images;
    private String sold;
    private String about;
    private String ownerId;
    private Integer hits;

    public BookVO(String id, String postMessage, String title, String price, String author,
        String publisher, List<String> category, List<String> state, String tradeMethod,
        List<String> images, String sold, String about, String ownerId, Integer hits) {
        this.id = id;
        this.postMessage = postMessage;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.state = state;
        this.tradeMethod = tradeMethod;
        this.images = images;
        this.sold = sold;
        this.about = about;
        this.ownerId = ownerId;
        this.hits = hits;
    }
}
