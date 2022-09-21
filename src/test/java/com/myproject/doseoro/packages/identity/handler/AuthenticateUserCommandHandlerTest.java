package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import com.myproject.doseoro.packages.infra.session.AccessUserSessionManager;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AuthenticateUserCommandHandlerTest {

    @Autowired
    private DoseoroDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("유저는 로그인을 할 수 있다.")
    @Transactional
    public void loginSuccessCommandHandler() {
        // given
        IdentityMybatisService repository = new IdentityMybatisService(dao, passwordEncoder);
        CreateUserIdentityCommandHandler createUserIdentityCommandHandler = new CreateUserIdentityCommandHandler(repository);
        AuthenticateUserCommandHandler sut = new AuthenticateUserCommandHandler(repository, accessUserSessionManager);

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
                "많은 추억",
                null
        );

        // when
        boolean actual = sut.handle(loginUser);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("유저는 유저 정보를 틀리게 입력하면 로그인을 할 수 없다.")
    @Transactional
    public void loginFailureCommandHandler() {
        // given
        IdentityMybatisService repository = new IdentityMybatisService(dao, passwordEncoder);
        CreateUserIdentityCommandHandler createUserIdentityCommandHandler = new CreateUserIdentityCommandHandler(repository);
        AuthenticateUserCommandHandler sut = new AuthenticateUserCommandHandler(repository, accessUserSessionManager);

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
                "7770777",
                "abcdef@naver.com",
                "aa",
                "홍길동",
                "길동이",
                "010-1234-5678",
                "좋아하는 추억",
                "많은 추억",
                null
        );

        // when
        boolean actual = sut.handle(loginUser);

        // then
        assertThat(actual).isFalse();
    }
}
