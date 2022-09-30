package com.myproject.doseoro.application.identity.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LogInVO {
    private String id;
    private String password;
    private String email;
    private String name;
    private String nickName;
    private String phone;
    private String forgotPwQuestion;
    private String forgotPwAnswer;

    public LogInVO(String id, String password, String email, String name, String nickName, String phone, String forgotPwQuestion, String forgotPwAnswer) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.forgotPwQuestion = forgotPwQuestion;
        this.forgotPwAnswer = forgotPwAnswer;
    }

    @Override
    public String toString() {
        return "LogInVO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", forgotPwQuestion='" + forgotPwQuestion + '\'' +
                ", forgotPwAnswer='" + forgotPwAnswer + '\'' +
                '}';
    }
}
