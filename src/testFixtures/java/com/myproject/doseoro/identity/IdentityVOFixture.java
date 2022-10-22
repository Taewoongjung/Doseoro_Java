package com.myproject.doseoro.identity;

import com.myproject.doseoro.application.identity.vo.IdentityVO;

public class IdentityVOFixture {
    public static IdentityVO identityVO = new IdentityVO(
            "7777777",
            "abcdefg@naver.com",
            "aa",
            "홍길동",
            "길동이",
            "010-1234-5678",
            "좋아하는 추억",
            "많은 추억"
    );

    public static IdentityVO identityVOEmailNotMatch = new IdentityVO(
            "7777777",
            "abceg@naver.com",
            "aa",
            "홍길동",
            "길동이",
            "010-1234-5678",
            "좋아하는 추억",
            "많은 추억"
    );

    public static IdentityVO identityVOPasswordNotMatch = new IdentityVO(
            "7777777",
            "abcdefg@naver.com",
            "a",
            "홍길동",
            "길동이",
            "010-1234-5678",
            "좋아하는 추억",
            "많은 추억"
    );
}
