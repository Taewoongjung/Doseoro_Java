package com.myproject.doseoro.application.identity.vo;

import lombok.Getter;

@Getter
public class AccessUserVO {
    private final String userId;
    private final String email;
    private final String nickName;

    public AccessUserVO(String userId, String email, String nickName) {
        this.userId = userId;
        this.email = email;
        this.nickName = nickName;
    }

    public static AccessUserVO of(IdentityVO vo) {
        return new AccessUserVO(vo.getId(), vo.getEmail(), vo.getNickName());
    }
}
