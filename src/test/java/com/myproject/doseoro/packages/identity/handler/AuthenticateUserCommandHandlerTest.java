package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AuthenticateUserCommandHandlerTest {

    @Autowired
    private DoseoroDao dao;

    @Test
    @DisplayName("유저는 로그인을 할 수 있다.")
    @Transactional
    public void commandHandler() {
        // given
        IdentityMybatisService repository = new IdentityMybatisService(dao);
        CreateUserIdentityCommandHandler createUserIdentityCommandHandler = new CreateUserIdentityCommandHandler(repository);
        AuthenticateUserCommandHandler sut = new AuthenticateUserCommandHandler(repository);

        SignUpVO signUpUser = new SignUpVO(
                "7777777",
                "abcdefg@naver.com",
                "aa",
                "홍길동",
                "길동이",
                "010-1234-5678",
                "좋아하는 추억",
                "많은 추억"
        );
        createUserIdentityCommandHandler.handle(signUpUser);

        IdentityVO loginUser = new IdentityVO(
                "7777777",
                "abcdefg@naver.com",
                "aa",
                "홍길동",
                "길동이",
                "010-1234-5678",
                "좋아하는 추억",
                "많은 추억"
        );

        // when
        IdentityVO actual = sut.handle(loginUser);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getEmail()).isEqualTo("abcdefg@naver.com");
        assertThat(actual.getName()).isEqualTo("홍길동");
        assertThat(actual.getNickName()).isEqualTo("길동이");
        assertThat(actual.getPhone()).isEqualTo("010-1234-5678");
        assertThat(actual.getForgotPwQuestion()).isEqualTo("좋아하는 추억");
        assertThat(actual.getForgotPwAnswer()).isEqualTo("많은 추억");
    }
}
