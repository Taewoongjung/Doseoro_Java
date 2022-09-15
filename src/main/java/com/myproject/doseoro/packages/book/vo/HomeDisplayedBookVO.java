package com.myproject.doseoro.packages.book.vo;

import com.google.gson.JsonArray;
import com.myproject.doseoro.global.util.JsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Builder
@NoArgsConstructor
public class HomeDisplayedBookVO {
    private String title;
    private String about;
    private String price;
    private JsonArray images;

    public HomeDisplayedBookVO(String title, String about, String price, JsonArray images) {
        this.title = title;
        this.about = about;
        this.price = price;
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeDisplayedBookVO that = (HomeDisplayedBookVO) o;
        return Objects.equals(title, that.title) && Objects.equals(about, that.about) && Objects.equals(price, that.price) && Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, about, price, images);
    }

    @Override
    public String toString() {
        return "HomeDisplayedBookVO{" +
                "title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", price='" + price + '\'' +
                ", images=" + images +
                '}';
    }
}
