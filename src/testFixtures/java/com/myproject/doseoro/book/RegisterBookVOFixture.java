package com.myproject.doseoro.book;

import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import java.util.ArrayList;
import java.util.List;

public class RegisterBookVOFixture {

    public static final RegisterBookVO registerBookVO() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return RegisterBookVO.builder()
            .id("1212131777")
            .postmessage("책 팔아요 ~ ")
            .title("당랑의 꿈")
            .price("77000")
            .author("휴먼")
            .publisher("실크로드")
            .checkCategory(checkCategory)
            .checkState(checkState)
            .images(images)
            .dealRoot("직접 거래")
            .sold("0")
            .about("좋은 책 이에요 ^^")
            .ownerId("19890879817")
            .ownerEmail("abcdefg@naver.com")
            .build();
    }

    public static final RegisterBookVO registerBookVOForDonation() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return RegisterBookVO.builder()
            .id("1212131777")
            .postmessage("책 팔아요 ~ ")
            .title("당랑의 꿈")
            .author("휴먼")
            .publisher("실크로드")
            .checkCategory(checkCategory)
            .checkState(checkState)
            .images(images)
            .dealRoot("직접 거래")
            .sold("0")
            .about("좋은 책 이에요 ^^")
            .ownerId("19890879817")
            .ownerEmail("abcdefg@naver.com/")
            .build();
    }
}
