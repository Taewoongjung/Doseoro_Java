package com.myproject.doseoro.domain.identity.dto;

import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.Getter;

@Getter
public class MyPageDtoResult {
    public MyPageDtoResult(IdentityMyPageVO user) {
        this.user = user;
    }

    private final IdentityMyPageVO user;

}
