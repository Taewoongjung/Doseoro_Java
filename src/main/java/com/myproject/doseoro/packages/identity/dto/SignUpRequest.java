package com.myproject.doseoro.packages.identity.dto;

import com.myproject.doseoro.packages.identity.domain.Identity;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest {

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String nickName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String question;

    @NotNull
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

    public Identity toEntity(final String uuid) {
        System.out.println("@@@@@@@  "+ toString());
        return Identity.builder()
                .id(uuid)
                .name(name)
                .phone(phoneNumber)
                .nickName(nickName)
                .email(email)
                .password(password)
                .forgotPwQuestion(question)
                .forgotPwAnswer(answerForQuestion)
                .build();
    }
}
