package com.myproject.doseoro.infra.mybatis;

import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.*;

@WebAppConfiguration()
@MybatisTest
class IdentityMybatisRepositoryTest {

    @Autowired
    @Test
    @DisplayName("DB에 있는 email 찾을 수 있다.")
    void findEmail() throws Exception {
        System.out.println("aaaaaaa");
        SignUpRequest dto = new SignUpRequest(
                "a", "1",
                "aa", "a@a",
                "aaa", "a",
                "aaaaaa", "a"
        );
//        CreateUserIdentityCommandHandler handler = new CreateUserIdentityCommandHandler();
//        handler.findEmail(dto);
    }
}
