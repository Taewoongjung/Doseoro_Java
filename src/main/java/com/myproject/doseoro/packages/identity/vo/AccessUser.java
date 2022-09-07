package com.myproject.doseoro.packages.identity.vo;

import lombok.Getter;

@Getter
public class AccessUser {
    private final String userId;
    private final String email;
    private final String nickName;

    public AccessUser(String userId, String email, String nickName) {
        this.userId = userId;
        this.email = email;
        this.nickName = nickName;
    }

    public static AccessUser of(IdentityVO vo) {
        return new AccessUser(vo.getId(), vo.getEmail(), vo.getNickName());
    }
}
