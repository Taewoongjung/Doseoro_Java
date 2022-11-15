package com.myproject.doseoro.application.identity.vo;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
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

    public SignUpVO(
        final String id,
        final String email,
        final String password,
        final String name,
        final String nickName,
        final String phoneNumber,
        final String question,
        final String answerForQuestion
    ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.question = question;
        this.answerForQuestion = answerForQuestion;
    }

    public void imbueUserId() {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
    }

    public void imbueUserPassword(String password) {
        this.password = password;
    }
}
