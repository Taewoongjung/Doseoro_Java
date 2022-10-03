package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

        SignUpVO user = new SignUpVO(
                "19890879817",
                "a@a.com",
                "aa",
                "홍길동",
                "길동이",
                "010-1234-5678",
                "좋아하는 추억",
                "많은 추억"
        );
        singUp.handle(user);

        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        RegisterBookVO registerBookVO = RegisterBookVO.builder()
                .id("1212131777")
                .postmessage("책 팔아요 ~ ")
                .title("당랑의 꿈")
                .price("77000")
                .publisher("실크로드")
                .checkCategory(checkCategory)
                .checkState(checkState)
                .images(images)
                .dealRoot("직접 거래")
                .sold("0")
                .about("좋은 책 이에요 ^^")
                .ownerId("19890879817")
                .ownerEmail("a@a.com")
                .build();
        RegisterBookVO book = registerBookCommandHandler.handle(registerBookVO);

        sut.handle(book.getId());
        sut.handle(book.getId());

        BookVO actual = bookRepository.findBookByBookId(book.getId());

        assertThat(actual).isNotNull();
        assertThat(actual.getHits()).isEqualTo(2);
    }
}