package com.myproject.doseoro.book;

import com.myproject.doseoro.application.book.vo.FindAllBooksVO;

import java.util.ArrayList;
import java.util.List;

public class FindAllBooksVOFixture {

    public static final FindAllBooksVO firstFindAllBooksVO() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return FindAllBooksVO.builder()
                .id("123")
                .postMessage("책 팔아요 ~")
                .title("읽으면 좋은 책")
                .price("70000000000000")
                .author("천재")
                .publisher("천재 모임")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .OwnerId("111")
                .build();
    }

    public static final FindAllBooksVO secondFindAllBooksVO() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return FindAllBooksVO.builder()
                .id("113")
                .postMessage("책 팜요 ~")
                .title("읽으면 정말 좋은 책")
                .price("7000000")
                .author("천재 작가")
                .publisher("천재 작가 모임")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .OwnerId("111")
                .build();
    }

    public static final FindAllBooksVO notForSaleFindAllBooksVO() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return FindAllBooksVO.builder()
                .id("123")
                .postMessage("책 팔아요 ~")
                .title("읽으면 좋은 책")
                .price("70000000000000")
                .author("천재")
                .publisher("천재 모임")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .OwnerId("111")
                .build();
    }
}
