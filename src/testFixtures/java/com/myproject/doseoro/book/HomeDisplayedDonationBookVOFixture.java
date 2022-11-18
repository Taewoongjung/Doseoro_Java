package com.myproject.doseoro.book;

import com.myproject.doseoro.application.book.vo.HomeDisplayedDonationBookVO;
import java.util.ArrayList;
import java.util.List;

public class HomeDisplayedDonationBookVOFixture {

    public static List<HomeDisplayedDonationBookVO> homeDisplayedSaleBookVOList() {
        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        HomeDisplayedDonationBookVO fir = HomeDisplayedDonationBookVO.builder()
            .id("1")
            .title("hi")
            .about("11")
            .images(images)
            .build();

        HomeDisplayedDonationBookVO sec = HomeDisplayedDonationBookVO.builder()
            .id("2")
            .title("hi")
            .about("22")
            .images(images)
            .build();

        HomeDisplayedDonationBookVO thr = HomeDisplayedDonationBookVO.builder()
            .id("3")
            .title("hi")
            .about("33")
            .images(images)
            .build();

        HomeDisplayedDonationBookVO frt = HomeDisplayedDonationBookVO.builder()
            .id("4")
            .title("hi")
            .about("44")
            .images(images)
            .build();

        HomeDisplayedDonationBookVO fif = HomeDisplayedDonationBookVO.builder()
            .id("5")
            .title("hi")
            .about("55")
            .images(images)
            .build();

        HomeDisplayedDonationBookVO six = HomeDisplayedDonationBookVO.builder()
            .id("6")
            .title("hi")
            .about("66")
            .images(images)
            .build();

        List<HomeDisplayedDonationBookVO> list = new ArrayList<>();
        list.add(fir);
        list.add(sec);
        list.add(thr);
        list.add(frt);
        list.add(fif);
        list.add(null);

        return list;
    }

}
