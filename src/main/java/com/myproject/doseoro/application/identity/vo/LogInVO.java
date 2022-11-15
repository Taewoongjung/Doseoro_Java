package com.myproject.doseoro.application.identity.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogInVO {

    private final String id;
    private final String password;
    private final String email;
    private final String name;
    private final String nickName;
    private final String phone;
    private final String forgotPwQuestion;
    private final String forgotPwAnswer;

    public LogInVO(
        final String id,
        final String password,
        final String email,
        final String name,
        final String nickName,
        final String phone,
        final String forgotPwQuestion,
        final String forgotPwAnswer
    ) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.forgotPwQuestion = forgotPwQuestion;
        this.forgotPwAnswer = forgotPwAnswer;
    }
}
