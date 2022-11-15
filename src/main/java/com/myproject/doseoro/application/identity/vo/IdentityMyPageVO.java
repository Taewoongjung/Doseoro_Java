package com.myproject.doseoro.application.identity.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class IdentityMyPageVO {

    private final String id;
    private final String email;
    private final String name;
    private final String nickName;
    private final String phone;
    private final String location;
    private final String dong;
    private final String si;
    private final String dou;
    private final String provider;
    private final String snsId;
    private final String updatedAt;

    public IdentityMyPageVO(
        final String id,
        final String email,
        final String name,
        final String nickName,
        final String phone,
        final String location,
        final String dong,
        final String si,
        final String dou,
        final String provider,
        final String snsId,
        final String updatedAt
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.location = location;
        this.dong = dong;
        this.si = si;
        this.dou = dou;
        this.provider = provider;
        this.snsId = snsId;
        this.updatedAt = updatedAt;
    }
}
