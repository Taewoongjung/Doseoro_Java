package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.global.error.exception.BusinessException;
import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.infra.dao.IdentityDao;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.application.identity.vo.IdentityVO;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.identity.IdentityVOFixture;
import com.myproject.doseoro.identity.SignUpVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AuthenticateUserCommandHandlerTest {

    @Autowired
    private IdentityDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("유저는 로그인을 할 수 있다.")
    @Transactional
    public void loginSuccessCommandHandler() {
        // given
        IdentityMybatisRepository repository = new IdentityMybatisRepository(dao, passwordEncoder);
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
                "많은 추억"
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
        IdentityMybatisRepository repository = new IdentityMybatisRepository(dao, passwordEncoder);
        CreateUserIdentityCommandHandler createUserIdentityCommandHandler = new CreateUserIdentityCommandHandler(repository);
        AuthenticateUserCommandHandler sut = new AuthenticateUserCommandHandler(repository, accessUserSessionManager);

        SignUpVO signUpUser = SignUpVOFixture.signUpVOWhenMakesWrong;
        createUserIdentityCommandHandler.handle(signUpUser);

        IdentityVO loginUser = IdentityVOFixture.identityVO;

        // when
        // then
        assertThrows(BusinessException.class, () -> sut.handle(loginUser));
    }
}
