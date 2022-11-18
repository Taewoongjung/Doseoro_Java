package com.myproject.doseoro.book;

import com.myproject.doseoro.application.book.vo.HomeDisplayedSaleBookVO;
import java.util.ArrayList;
import java.util.List;

public class HomeDisplayedSaleBookVOFixture {

    public static List<HomeDisplayedSaleBookVO> homeDisplayedSaleBookVOList() {
        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        HomeDisplayedSaleBookVO fir = HomeDisplayedSaleBookVO.builder()
            .id("1")
            .title("hi")
            .about("11")
            .price("1000")
            .images(images)
            .build();

        HomeDisplayedSaleBookVO sec = HomeDisplayedSaleBookVO.builder()
            .id("2")
            .title("hi")
            .about("22")
            .price("2000")
            .images(images)
            .build();

        HomeDisplayedSaleBookVO thr = HomeDisplayedSaleBookVO.builder()
            .id("3")
            .title("hi")
            .about("33")
            .price("3000")
            .images(images)
            .build();

        HomeDisplayedSaleBookVO frt = HomeDisplayedSaleBookVO.builder()
            .id("4")
            .title("hi")
            .about("44")
            .price("4000")
            .images(images)
            .build();

        HomeDisplayedSaleBookVO fif = HomeDisplayedSaleBookVO.builder()
            .id("5")
            .title("hi")
            .about("55")
            .price("5000")
            .images(images)
            .build();

        HomeDisplayedSaleBookVO six = HomeDisplayedSaleBookVO.builder()
            .id("6")
            .title("hi")
            .about("66")
            .price("6000")
            .images(images)
            .build();

        List<HomeDisplayedSaleBookVO> list = new ArrayList<>();
        list.add(fir);
        list.add(sec);
        list.add(thr);
        list.add(frt);
        list.add(fif);
        list.add(null);

        return list;
    }

}
