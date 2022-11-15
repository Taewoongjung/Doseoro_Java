package com.myproject.doseoro.application.book.vo;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class HomeDisplayedBookVO {

    private final String id;
    private final String title;
    private final String about;
    private final String price;
    private final List<String> images;
}
