package com.myproject.doseoro.infra.security.role;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIJN"),
    USER("ROLE_USER");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

}
