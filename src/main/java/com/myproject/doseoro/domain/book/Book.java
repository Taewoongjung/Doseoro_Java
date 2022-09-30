package com.myproject.doseoro.domain.book;

import lombok.*;

import java.util.ArrayList;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long seq;

    private String id;

    private String title;

    private String price;

    private String author;

    private String publisher;

    private ArrayList<String> category;

    private String damaged;

    private String state;

    private ArrayList<String> img;

    private String like;

    private String sold;

    private String about;
}
