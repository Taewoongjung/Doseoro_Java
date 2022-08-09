package com.myproject.doseoro.packages.identity.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdentityResponse {
    private String id;

    public IdentityResponse(String id) {
        this.id = id;
    }
}
