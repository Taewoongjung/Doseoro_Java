package com.myproject.doseoro.packages.identity.domain;

import lombok.*;
import org.springframework.lang.Nullable;

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

    @Nullable
    private String location;

    @Nullable
    private String dong;

    @Nullable
    private String si;

    @Nullable
    private String dou; // 도 ex) 경기"도"

    @Nullable
    private String provider;

    @Nullable
    private String snsId;
}
