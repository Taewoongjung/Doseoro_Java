package com.myproject.doseoro.application.identity.dto;

import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetUserInformationDtoResult {

    private final IdentityMyPageVO user;

}
