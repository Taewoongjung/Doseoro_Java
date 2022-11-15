package com.myproject.doseoro.application.identity.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IdentityDTO implements Serializable {

    @NotBlank
    private final String id;
    private final String email;
    private final String password;
    private final String name;
    private final String nickName;
    private final String phone;
    private final String forgotPwQuestion;
    private final String forgotPwAnswer;
}
