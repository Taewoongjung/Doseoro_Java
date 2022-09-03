package com.myproject.doseoro.packages.identity.domain;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Identity {

    private Long seq;

    private String id;

    private String email;

    private String password;

    private String name;

    private String nickName;

    private String phone;

    private String forgotPwQuestion;

    private String forgotPwAnswer;

    private String liked;

    private String location;

    private String dong;

    private String si;

    private String dou; // 도 ex) 경기"도"

    private String provider;

    private String snsId;
}
