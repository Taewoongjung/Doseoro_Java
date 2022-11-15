package com.myproject.doseoro.application.identity.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessUserVO {

    private final String userId;
    private final String email;
    private final String nickName;

    public AccessUserVO(String userId, String email, String nickName) {
        this.userId = userId;
        this.email = email;
        this.nickName = nickName;
    }
}
