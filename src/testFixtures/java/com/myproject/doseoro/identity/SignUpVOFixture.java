package com.myproject.doseoro.identity;

import com.myproject.doseoro.application.identity.vo.SignUpVO;

public class SignUpVOFixture {

    public static SignUpVO signUpVO = new SignUpVO(
            "7777777",
            "abcdefg@naver.com",
            "aa",
            "홍길동",
            "길동이",
            "010-1234-5678",
            "좋아하는 추억",
            "많은 추억"
    );


    public static SignUpVO signUpVOWhenMakesWrong = new SignUpVO(
            "7777777",
            "aaa@naver.com",
            "aa",
            "홍길동",
            "길동이",
            "010-1234-5678",
            "좋아하는 추억",
            "많은 추억"
    );
}
