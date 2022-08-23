package com.myproject.doseoro.infra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordEncoderTest {

    @BeforeEach
    public void beforeEach() {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        WebSecurityConfig ws = ac.getBean(WebSecurityConfig.class);
//        passwordEncoder = ws.passwordEncoder();
    }

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncoder() {
        System.out.println("테스트");
    }
}
