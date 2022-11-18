package com.myproject.doseoro.book;

import com.myproject.doseoro.application.book.vo.HomeDisplayedBuyingBookVO;
import java.util.ArrayList;
import java.util.List;

public class HomeDisplayedBuyingBookVOFixture {

    public static List<HomeDisplayedBuyingBookVO> HomeDisplayedBuyingBookVOList() {

        HomeDisplayedBuyingBookVO fir = HomeDisplayedBuyingBookVO.builder()
            .id("1")
            .postMessage("hi")
            .about("11")
            .userNickName("11")
            .build();

        HomeDisplayedBuyingBookVO sec = HomeDisplayedBuyingBookVO.builder()
            .id("2")
            .postMessage("hi")
            .about("22")
            .userNickName("22")
            .build();

        HomeDisplayedBuyingBookVO thr = HomeDisplayedBuyingBookVO.builder()
            .id("3")
            .postMessage("hi")
            .about("33")
            .userNickName("33")
            .build();

        HomeDisplayedBuyingBookVO frt = HomeDisplayedBuyingBookVO.builder()
            .id("4")
            .postMessage("hi")
            .about("44")
            .userNickName("44")
            .build();

        HomeDisplayedBuyingBookVO fif = HomeDisplayedBuyingBookVO.builder()
            .id("5")
            .postMessage("hi")
            .about("55")
            .userNickName("55")
            .build();

        List<HomeDisplayedBuyingBookVO> list = new ArrayList<>();
        list.add(fir);
        list.add(sec);
        list.add(thr);
        list.add(frt);
        list.add(null);

        return list;
    }
}
