package com.myproject.doseoro.application.book.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import com.myproject.doseoro.book.RegisterBookVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(MockitoExtension.class)
class RegisterDonationBookCommandHandlerTest {

    @InjectMocks
    private RegisterDonationBookCommandHandler sut;
    @Mock
    private BookRepository repository;
    @Mock
    private IdentityRepository identityRepository;

    @Test
    @Transactional
    @DisplayName("유저는 무료나눔 책을 등록할 수 있다.")
    void test() {
        // given
        RegisterBookVO registerBook = RegisterBookVOFixture.registerBookVO();
        when(identityRepository.findUserByEmail("abcdefg@naver.com"))
            .thenReturn(new AccessUserVO("1", "abcdefg@naver.com", "태웅"));
        sut.handle(registerBook);

        // when
        RegisterBookVO actual = sut.handle(registerBook);

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