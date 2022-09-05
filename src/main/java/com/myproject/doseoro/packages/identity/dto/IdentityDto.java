package com.myproject.doseoro.packages.identity.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class IdentityDto {

    private String id;
    private String email;
    private String password;
    private String name;
    private String nickName;
    private String phone;
    private String forgotPwQuestion;
    private String forgotPwAnswer;

    public IdentityDto(String id, String email, String password, String name, String nickName, String phone, String forgotPwQuestion, String forgotPwAnswer) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.forgotPwQuestion = forgotPwQuestion;
        this.forgotPwAnswer = forgotPwAnswer;
    }

    @Override
    public String toString() {
        return "IdentityDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", forgotPwQuestion='" + forgotPwQuestion + '\'' +
                ", forgotPwAnswer='" + forgotPwAnswer + '\'' +
                '}';
    }
}
