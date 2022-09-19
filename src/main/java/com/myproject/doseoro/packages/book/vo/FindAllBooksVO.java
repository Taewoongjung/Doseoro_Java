package com.myproject.doseoro.packages.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@NoArgsConstructor
public class FindAllBooksVO {

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
    private String likeCount;
    private String sold;
    private String about;
    private String OwnerId;

    public FindAllBooksVO(String id, String postMessage, String title, String price, String author, String publisher, List<String> category, List<String> state, String tradeMethod, List<String> images, String likeCount, String sold, String about, String ownerId) {
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
        this.likeCount = likeCount;
        this.sold = sold;
        this.about = about;
        OwnerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindAllBooksVO that = (FindAllBooksVO) o;
        return Objects.equals(id, that.id) && Objects.equals(postMessage, that.postMessage) && Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(author, that.author) && Objects.equals(publisher, that.publisher) && Objects.equals(category, that.category) && Objects.equals(state, that.state) && Objects.equals(tradeMethod, that.tradeMethod) && Objects.equals(images, that.images) && Objects.equals(likeCount, that.likeCount) && Objects.equals(sold, that.sold) && Objects.equals(about, that.about) && Objects.equals(OwnerId, that.OwnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postMessage, title, price, author, publisher, category, state, tradeMethod, images, likeCount, sold, about, OwnerId);
    }

    @Override
    public String toString() {
        return "FindAllBooksVO{" +
                "id='" + id + '\'' +
                ", postMessage='" + postMessage + '\'' +
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
