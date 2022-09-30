package com.myproject.doseoro.application.identity.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
public class IdentityDTO implements Serializable {

    @NotBlank
    private final String id;
    private final String email;
    private final String password;
    private final String name;
    private final String nickName;
    private final String phone;
    private final String forgotPwQuestion;
    private final String forgotPwAnswer;

    public IdentityDTO(String id, String email, String password, String name, String nickName, String phone, String forgotPwQuestion, String forgotPwAnswer) {
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
