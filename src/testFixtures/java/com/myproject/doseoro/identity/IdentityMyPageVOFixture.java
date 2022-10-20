package com.myproject.doseoro.identity;

import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;

public class IdentityMyPageVOFixture {
    public static IdentityMyPageVO createIdentityMyPageVO() {
        return new IdentityMyPageVO(
                "12312315256787",
                "a@a.com",
                "홍길동",
                "길도이",
                "010-2111-7777",
                "경기도 용인시 보정동",
                "보정동",
                "용인시",
                "경기도",
                "kakao",
                "12321-11",
                "11-11-11"
        );
    }
}
