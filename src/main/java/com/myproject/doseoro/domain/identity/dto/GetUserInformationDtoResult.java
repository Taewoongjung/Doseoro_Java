package com.myproject.doseoro.domain.identity.dto;

import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.Getter;

@Getter
public class GetUserInformationDtoResult {
    public GetUserInformationDtoResult(IdentityMyPageVO user) {
        this.user = user;
    }

    private final IdentityMyPageVO user;

}
