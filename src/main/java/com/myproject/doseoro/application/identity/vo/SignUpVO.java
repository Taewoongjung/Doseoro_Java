package com.myproject.doseoro.application.identity.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpVO {

    private String id;

    private String email;

    private String password;

    private String name;

    private String nickName;

    private String phoneNumber;

    private String question;

    private String answerForQuestion;

    public SignUpVO(String id, String email, String password, String name, String nickName, String phoneNumber, String question, String answerForQuestion) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.question = question;
        this.answerForQuestion = answerForQuestion;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", question='" + question + '\'' +
                ", answerForQuestion='" + answerForQuestion + '\'' +
                '}';
    }

    public void imbueUserId() {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
    }

    public void imbueUserPassword(String password) {
        this.password = password;
    }
}