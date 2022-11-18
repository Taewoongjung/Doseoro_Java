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
    private String donation;
    private String isBuying;

    public BookVO(
        final String id,
        final String postMessage,
        final String title,
        final String price,
        final String author,
        final String publisher,
        final List<String> category,
        final List<String> state,
        final String tradeMethod,
        final List<String> images,
        final String sold,
        final String about,
        final String ownerId,
        final Integer hits,
        final String donation,
        final String isBuying
    ) {
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
        this.donation = donation;
        this.isBuying = isBuying;
    }
}
