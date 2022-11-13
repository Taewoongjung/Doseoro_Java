package com.myproject.doseoro.application.book.handler;

import static org.assertj.core.api.Assertions.assertThat;

import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.book.RegisterBookVOFixture;
import com.myproject.doseoro.identity.SignUpVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class RegisterDonationBookCommandHandlerTest {

    @Autowired
    private RegisterDonationBookCommandHandler sut;

    @Autowired
    private CreateUserIdentityCommandHandler singUp;

    @Test
    @Transactional
    @DisplayName("무료나눔 책 등록")
    void test() {
        SignUpVO user = SignUpVOFixture.signUpVO;
        singUp.handle(user);

        RegisterBookVO registerBookVO = RegisterBookVOFixture.registerBookVOForDonation();
        RegisterBookVO actual = sut.handle(registerBookVO);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getPostmessage()).isEqualTo("책 팔아요 ~ ");
        assertThat(actual.getTitle()).isEqualTo("당랑의 꿈");
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