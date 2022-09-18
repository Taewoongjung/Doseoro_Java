package com.myproject.doseoro.packages.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@NoArgsConstructor
public class BookVO {

    private String postMessage;
    private String title;
    private String price;
    private String author;
    private String publisher;
    private List<String> category;
    private List<String> state;
    private String tradeMethod;
    private List<String> images;
    private String likeCount;
    private String sold;
    private String about;
    private String OwnerId;

    public BookVO(String postMessage, String title, String price, String author, String publisher, List<String> category, List<String> state, String tradeMethod, List<String> images, String likeCount, String sold, String about, String ownerId) {
        this.postMessage = postMessage;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.state = state;
        this.tradeMethod = tradeMethod;
        this.images = images;
        this.likeCount = likeCount;
        this.sold = sold;
        this.about = about;
        OwnerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookVO bookVo = (BookVO) o;
        return Objects.equals(postMessage, bookVo.postMessage) && Objects.equals(title, bookVo.title) && Objects.equals(price, bookVo.price) && Objects.equals(author, bookVo.author) && Objects.equals(publisher, bookVo.publisher) && Objects.equals(category, bookVo.category) && Objects.equals(state, bookVo.state) && Objects.equals(tradeMethod, bookVo.tradeMethod) && Objects.equals(images, bookVo.images) && Objects.equals(likeCount, bookVo.likeCount) && Objects.equals(sold, bookVo.sold) && Objects.equals(about, bookVo.about) && Objects.equals(OwnerId, bookVo.OwnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postMessage, title, price, author, publisher, category, state, tradeMethod, images, likeCount, sold, about, OwnerId);
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "postMessage='" + postMessage + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category=" + category +
                ", state=" + state +
                ", tradeMethod='" + tradeMethod + '\'' +
                ", images=" + images +
                ", likeCount='" + likeCount + '\'' +
                ", sold='" + sold + '\'' +
                ", about='" + about + '\'' +
                ", OwnerId='" + OwnerId + '\'' +
                '}';
    }
}
