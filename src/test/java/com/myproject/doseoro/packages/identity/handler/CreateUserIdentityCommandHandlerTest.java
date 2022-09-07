package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CreateUserIdentityCommandHandlerTest {

    @Autowired
    private DoseoroDao dao;

    @Test
    @DisplayName("유저인증 정보가 존재하지 않는다면 인증 정보를 생성한다.")
    @Transactional // 테스트 완료 후 rollback
    public void commandHandler() {
        // given
        IdentityMybatisService repository = new IdentityMybatisService(dao);

        String uuid = UUID.randomUUID().toString();
        SignUpVO user = new SignUpVO(
                uuid,
                "abcdefg@naver.com",
                "aa",
                "홍길동",
                "길동이",
                "010-1234-5678",
                "좋아하는 추억",
                "많은 추억"
        );

        // when
        repository.signUp(user);
        SignUpVO actual = repository.findUser(user.getEmail());

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(uuid);
        assertThat(actual.getEmail()).isEqualTo("abcdefg@naver.com");
        assertThat(actual.getName()).isEqualTo("홍길동");
        assertThat(actual.getNickName()).isEqualTo("길동이");
        assertThat(actual.getPhoneNumber()).isEqualTo("010-1234-5678");
        assertThat(actual.getQuestion()).isEqualTo("좋아하는 추억");
        assertThat(actual.getAnswerForQuestion()).isEqualTo("많은 추억");
    }

    @Test
    @DisplayName("같은 유저 정보가 있을 경우 에러를 반환한다.")
    @Transactional // 테스트 완료 후 rollback
    public void errorTest() {
        // given
        IdentityMybatisService repository = new IdentityMybatisService(dao);

        String uuid = UUID.randomUUID().toString();
        SignUpVO user = new SignUpVO(
                uuid,
                "abcdefg@naver.com",
                "aa",
                "홍길동",
                "길동이",
                "010-1234-5678",
                "좋아하는 추억",
                "많은 추억"
        );

        // when
        repository.signUp(user);

        // then
    }
}
