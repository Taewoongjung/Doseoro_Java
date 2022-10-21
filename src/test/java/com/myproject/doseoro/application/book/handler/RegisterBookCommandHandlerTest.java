package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.infra.dao.BookDao;
import com.myproject.doseoro.adaptor.infra.dao.IdentityDao;
import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.book.RegisterBookVOFixture;
import com.myproject.doseoro.identity.SignUpVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RegisterBookCommandHandlerTest {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private IdentityDao identityDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("유저는 새로운 책을 등록할 수 있다.")
    @Transactional
    public void handle() {
        // given
        BookMybatisRepository bookRepository = new BookMybatisRepository(bookDao);
        IdentityMybatisRepository identityRepository = new IdentityMybatisRepository(identityDao, passwordEncoder);
        RegisterBookCommandHandler sut = new RegisterBookCommandHandler(bookRepository, identityRepository);

        CreateUserIdentityCommandHandler singUp = new CreateUserIdentityCommandHandler(identityRepository);

        SignUpVO user = SignUpVOFixture.signUpVO;
        singUp.handle(user);

        RegisterBookVO registerBook = RegisterBookVOFixture.registerBookVO();

        // when
        RegisterBookVO actual = sut.handle(registerBook);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getPostmessage()).isEqualTo("책 팔아요 ~ ");
        assertThat(actual.getTitle()).isEqualTo("당랑의 꿈");
        assertThat(actual.getPrice()).isEqualTo("77000");
        assertThat(actual.getAuthor()).isEqualTo("휴먼");
        assertThat(actual.getPublisher()).isEqualTo("실크로드");
        assertThat(actual.getCheckCategory()).contains("SF");
        assertThat(actual.getCheckCategory()).contains("만화");
        assertThat(actual.getCheckState()).contains("깨끗");
        assertThat(actual.getCheckState()).contains("거의 새책");
        assertThat(actual.getImages()).contains("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        assertThat(actual.getImages()).contains("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");
        assertThat(actual.getDealRoot()).isEqualTo("직접 거래");
        assertThat(actual.getSold()).isEqualTo("0");
        assertThat(actual.getAbout()).isEqualTo("좋은 책 이에요 ^^");
        assertThat(actual.getOwnerEmail()).isEqualTo("abcdefg@naver.com");
    }
}
