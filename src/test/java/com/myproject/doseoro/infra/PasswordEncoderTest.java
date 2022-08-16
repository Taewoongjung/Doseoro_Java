package com.myproject.doseoro.infra;

import com.myproject.doseoro.AutoAppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

class PasswordEncoderTest {

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void beforeEach() {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        WebSecurityConfig ws = ac.getBean(WebSecurityConfig.class);
//        passwordEncoder = ws.passwordEncoder();

        WebSecurityConfig ws = new WebSecurityConfig();
        passwordEncoder = ws.passwordEncoder();
    }

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncoder() {
        // given
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        WebSecurityConfig ws = ac.getBean(WebSecurityConfig.class);
        String rawPassword = "12345677";

        // when
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // then
        assertThat(encodedPassword).isNotEqualTo(rawPassword);
        assertThat(passwordEncoder.matches(rawPassword, encodedPassword)).isTrue();
    }
}
