package com.myproject.doseoro.application.identity.dto;

import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import lombok.Getter;

@Getter
public class GetUserInformationDtoResult {
    public GetUserInformationDtoResult(IdentityMyPageVO user) {
        this.user = user;
    }

    private final IdentityMyPageVO user;

}
