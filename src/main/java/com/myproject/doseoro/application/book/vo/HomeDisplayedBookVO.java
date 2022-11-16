package com.myproject.doseoro.application.book.vo;

import java.util.List;
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
public class HomeDisplayedBookVO {

    private String id;
    private String title;
    private String about;
    private String price;
    private List<String> images;

    public HomeDisplayedBookVO(String id, String title, String about, String price,
        List<String> images) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.price = price;
        this.images = images;
    }
}
