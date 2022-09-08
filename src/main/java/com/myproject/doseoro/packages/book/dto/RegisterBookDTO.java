package com.myproject.doseoro.packages.book.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
public class RegisterBookDTO implements Serializable {

    private final String title;
    private final String price;
    private final String author;
    private final String publisher;
    private final ArrayList<String> categories;
    private final ArrayList<String> damaged;
    private final String state;
    private final String wayToTrade;
    private final String sold;
    private final String about;

    public RegisterBookDTO(String title, String price, String author, String publisher, ArrayList<String> categories, ArrayList<String> damaged, String state, String wayToTrade, String sold, String about) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.categories = categories;
        this.damaged = damaged;
        this.state = state;
        this.wayToTrade = wayToTrade;
        this.sold = sold;
        this.about = about;
    }

    @Override
    public String toString() {
        return "RegisterBookDTO{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", categories=" + categories +
                ", damaged=" + damaged +
                ", state='" + state + '\'' +
                ", wayToTrade='" + wayToTrade + '\'' +
                ", sold='" + sold + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
