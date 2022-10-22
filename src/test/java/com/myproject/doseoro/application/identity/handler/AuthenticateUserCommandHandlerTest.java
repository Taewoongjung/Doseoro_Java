package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.global.error.exception.BusinessException;
import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.application.identity.vo.IdentityVO;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.identity.IdentityVOFixture;
import com.myproject.doseoro.identity.SignUpVOFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static com.myproject.doseoro.adaptor.global.error.exception.ErrorCode.EMAIL_NOT_MATCHED;
import static com.myproject.doseoro.adaptor.global.error.exception.ErrorCode.PASSWORD_NOT_MATCHED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticateUserCommandHandlerTest {

    @InjectMocks
    AuthenticateUserCommandHandler sut;
    @InjectMocks
    CreateUserIdentityCommandHandler createUserIdentityCommandHandler;
    @Mock
    private IdentityMybatisRepository repository;
    @Mock
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("유저는 로그인을 할 수 있다.")
    @Transactional
    public void loginSuccessCommandHandler() {

        // given
//        SignUpVO signUpUser = new SignUpVO(
//                "7777777",
//                "abcdefg@naver.com",
//                "aa",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
        SignUpVO signUpUser = SignUpVOFixture.signUpVO;
        createUserIdentityCommandHandler.handle(signUpUser);

//        IdentityVO loginUser = new IdentityVO(
//                "7777777",
//                "abcdefg@naver.com",
//                "aa",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
        IdentityVO loginUser = IdentityVOFixture.identityVO;
        // when
        boolean actual = sut.handle(loginUser);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("유저는 아이디를 틀리게 입력하면 로그인 할 수 없다.")
    @Transactional
    public void loginEmailNotMatchedFailureCommandHandler() {

        // given
//        SignUpVO signUpUser = new SignUpVO(
//                "7777777",
//                "abcdefg@naver.com",
//                "aa",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
        SignUpVO signUpUser = SignUpVOFixture.signUpVO;
        createUserIdentityCommandHandler.handle(signUpUser);

//        IdentityVO loginUser = new IdentityVO(
//                "7777777",
//                "abcef@naver.com",
//                "aa",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
        IdentityVO loginUser = IdentityVOFixture.identityVOEmailNotMatch;
        // when
        when(repository.loginCheck(loginUser)).thenThrow(new BusinessException(EMAIL_NOT_MATCHED));

        // then
        Assertions.assertThrows(BusinessException.class,
                () -> sut.handle(loginUser),
                "Email is not matched");
    }

    @Test
    @DisplayName("유저는 비밀번호를 틀리게 입력하면 로그인 할 수 없다.")
    @Transactional
    public void loginPasswordNotMatchedFailureCommandHandler() {

        // given
//        SignUpVO signUpUser = new SignUpVO(
//                "7777777",
//                "abcdefg@naver.com",
//                "aa",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
        SignUpVO signUpUser = SignUpVOFixture.signUpVO;
        createUserIdentityCommandHandler.handle(signUpUser);

//        IdentityVO loginUser = new IdentityVO(
//                "7777777",
//                "abcdef@naver.com",
//                "a",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
        IdentityVO loginUser = IdentityVOFixture.identityVOPasswordNotMatch;

        // when
        when(repository.loginCheck(loginUser)).thenThrow(new BusinessException(PASSWORD_NOT_MATCHED));

        // then
        Assertions.assertThrows(BusinessException.class,
                () -> sut.handle(loginUser),
                "Password is not matched");
    }
}
