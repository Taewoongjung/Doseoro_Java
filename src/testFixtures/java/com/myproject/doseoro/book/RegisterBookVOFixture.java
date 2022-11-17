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

        return new RegisterBookVO(
            "1212131777",
            "책 팔아요 ~ ",
            "당랑의 꿈",
            "77000",
            "휴먼",
            "실크로드",
            checkCategory,
            checkState,
            images,
            "직접 거래",
            "0",
            "좋은 책 이에요 ^^",
            "19890879817",
            "abcdefg@naver.com"
        );
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

        return new RegisterBookVO(
            "1212131777",
            "책 팔아요 ~ ",
            "당랑의 꿈",
            null,
            "휴먼",
            "실크로드",
            checkCategory,
            checkState,
            images,
            "직접 거래",
            "0",
            "좋은 책 이에요 ^^",
            "19890879817",
            "abcdefg@naver.com"
        );
    }

    public static final RegisterBookVO registerBookVOForBuying() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        return new RegisterBookVO(
            "1212131777",
            "책 팔아요 ~ ",
            "당랑의 꿈",
            "77000",
            "휴먼",
            "실크로드",
            checkCategory,
            null,
            null,
            "직접 거래",
            "0",
            "좋은 책 이에요 ^^",
            "19890879817",
            "abcdefg@naver.com"
        );
    }
}
