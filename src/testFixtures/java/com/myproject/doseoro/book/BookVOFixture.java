package com.myproject.doseoro.book;

import com.myproject.doseoro.application.book.vo.BookVO;

import java.util.ArrayList;
import java.util.List;

public class BookVOFixture {
    public static final BookVO firstBookVO() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return BookVO.builder()
                .id("777")
                .postMessage("책팝니다 ~")
                .title("정말 재미 있는 책")
                .price("100000")
                .author("난 천재")
                .publisher("출판사")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .tradeMethod("직거래")
                .sold("0")
                .about("재미있는 책 팜")
                .OwnerId("12312315256787")
                .build();
    }

    public static final BookVO secondBookVO() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return BookVO.builder()
                .id("121112")
                .postMessage("이 책 팔아요")
                .title("재미있는 책")
                .price("100000")
                .author("천재")
                .publisher("출판사")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .tradeMethod("직거래")
                .sold("0")
                .about("재미있는 책 팜")
                .OwnerId("12312315256787")
                .build();
    }
}