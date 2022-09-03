package com.myproject.doseoro.packages.identity.dto;

import com.myproject.doseoro.packages.identity.domain.Identity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest implements Serializable {

    private String name;

    private String phoneNumber;

    private String nickName;

    private String email;

    private String password;

    private String question;

    private String answerForQuestion;

    public SignUpRequest(String name, String phoneNumber, String nickName, String email, String password, String question, String answerForQuestion) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.question = question;
        this.answerForQuestion = answerForQuestion;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answerForQuestion='" + answerForQuestion + '\'' +
                '}';
    }

}
