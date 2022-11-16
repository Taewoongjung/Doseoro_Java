package com.myproject.doseoro.application.book.handler;

import static org.assertj.core.api.Assertions.assertThat;

import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.book.RegisterBookVOFixture;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.identity.SignUpVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class AddHitWhenBookClickedCommandHandlerTest {

    @Autowired
    private AddHitWhenBookClickedCommandHandler sut;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RegisterBookCommandHandler registerBookCommandHandler;
    @Autowired
    private CreateUserIdentityCommandHandler singUp;

    @Test
    @Transactional
    @DisplayName("해당 책을 두 번 클릭 하면 조회수 2 만큼 증가한다.")
    void test() {

        SignUpVO user = SignUpVOFixture.signUpVO;
        singUp.handle(user);

        RegisterBookVO registerBookVO = RegisterBookVOFixture.registerBookVO();
        RegisterBookVO book = registerBookCommandHandler.handle(registerBookVO);

        sut.handle(book.getId());
        sut.handle(book.getId());

        BookVO actual = bookRepository.findBookByBookId(book.getId());

        assertThat(actual).isNotNull();
        assertThat(actual.getHits()).isEqualTo(2);
    }
}