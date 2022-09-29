package com.myproject.doseoro.domain.book.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
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
    private String OwnerId;

    public BookVO(String id, String postMessage, String title, String price, String author, String publisher, List<String> category, List<String> state, String tradeMethod, List<String> images, String sold, String about, String ownerId) {
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
        OwnerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookVO bookVO = (BookVO) o;
        return Objects.equals(id, bookVO.id) && Objects.equals(postMessage, bookVO.postMessage) && Objects.equals(title, bookVO.title) && Objects.equals(price, bookVO.price) && Objects.equals(author, bookVO.author) && Objects.equals(publisher, bookVO.publisher) && Objects.equals(category, bookVO.category) && Objects.equals(state, bookVO.state) && Objects.equals(tradeMethod, bookVO.tradeMethod) && Objects.equals(images, bookVO.images) && Objects.equals(sold, bookVO.sold) && Objects.equals(about, bookVO.about) && Objects.equals(OwnerId, bookVO.OwnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postMessage, title, price, author, publisher, category, state, tradeMethod, images, sold, about, OwnerId);
    }

    @Override
    public String toString() {
        return "BookVO{" +
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
                ", sold='" + sold + '\'' +
                ", about='" + about + '\'' +
                ", OwnerId='" + OwnerId + '\'' +
                '}';
    }
}
