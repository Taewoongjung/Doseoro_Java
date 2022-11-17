package com.myproject.doseoro.application.book.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import com.myproject.doseoro.book.RegisterBookVOFixture;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(MockitoExtension.class)
class RegisterBuyingBookCommandHandlerTest {

    @InjectMocks
    private RegisterBuyingBookCommandHandler sut;
    @Mock
    private BookRepository repository;
    @Mock
    private IdentityRepository identityRepository;

    @Test
    @Transactional
    @DisplayName("유저는 책 삽니다를 등록할 수 있다.")
    void test() {
        // given
        RegisterBookVO registerBook = RegisterBookVOFixture.registerBookVOForBuying();
        when(identityRepository.findUserByEmail("abcdefg@naver.com"))
            .thenReturn(new AccessUserVO("1", "abcdefg@naver.com", "태웅"));

        // when
        RegisterBookVO actual = sut.handle(registerBook);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getPostmessage()).isEqualTo("책 사요 ~ ");
        assertThat(actual.getTitle()).isEqualTo("당랑의 꿈");
        assertThat(actual.getPrice()).isEqualTo("7777777");
        assertThat(actual.getAuthor()).isEqualTo("휴먼");
        assertThat(actual.getPublisher()).isEqualTo("실크로드");
        assertThat(actual.getCheckCategory()).contains("SF");
        assertThat(actual.getCheckCategory()).contains("만화");
        assertThat(actual.getDealRoot()).isEqualTo("직접 거래");
        assertThat(actual.getSold()).isEqualTo("0");
        assertThat(actual.getAbout()).isEqualTo("좋은 책 읽고싶어요 ^^");
        assertThat(actual.getOwnerEmail()).isEqualTo("abcdefg@naver.com");
    }
}