package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.global.error.exception.BusinessException;
import com.myproject.doseoro.adaptor.infra.dao.IdentityDao;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.identity.SignUpVOFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CreateUserIdentityCommandHandlerTest {

    @Autowired
    private IdentityDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("유저인증 정보가 존재하지 않는다면 인증 정보를 생성한다.")
    @Transactional // 테스트 완료 후 rollback
    public void commandHandler() {
        // given
        IdentityMybatisRepository repository = new IdentityMybatisRepository(dao, passwordEncoder);
        SignUpVO user = SignUpVOFixture.createSignUpVO();

        CreateUserIdentityCommandHandler sut = new CreateUserIdentityCommandHandler(repository);

        // when
        sut.handle(user);

        // then
        SignUpVO actual = repository.findUser(user.getEmail());

        assertThat(actual).isNotNull();
        assertThat(actual.getEmail()).isEqualTo("abcdefg@naver.com");
        assertThat(actual.getName()).isEqualTo("홍길동");
        assertThat(actual.getNickName()).isEqualTo("길동이");
        assertThat(actual.getPhoneNumber()).isEqualTo("010-1234-5678");
        assertThat(actual.getQuestion()).isEqualTo("좋아하는 추억");
        assertThat(actual.getAnswerForQuestion()).isEqualTo("많은 추억");
    }

    @Test
    @DisplayName("같은 유저 정보가 있을 경우 에러를 반환한다.")
    @Transactional
    public void errorTest() {
        // given
        IdentityMybatisRepository repository = new IdentityMybatisRepository(dao, passwordEncoder);

        SignUpVO user = SignUpVOFixture.createSignUpVO();
        repository.signUp(user);

        CreateUserIdentityCommandHandler sut = new CreateUserIdentityCommandHandler(repository);

        // when
        // then
        Assertions.assertThrows(BusinessException.class, () -> sut.handle(user));
    }
}
