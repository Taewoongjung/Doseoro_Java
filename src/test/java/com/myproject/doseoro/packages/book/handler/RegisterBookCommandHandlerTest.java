package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.packages.book.vo.RegisterBookVO;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class RegisterBookCommandHandlerTest {

    @Autowired
    private DoseoroDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setBookTable() {
        String query = "create table if not exists t_book\n" +
                "(\n" +
                "seq bigint generated by default as identity,\n" +
                "id varchar(64) not null,\n" +
                "post_message varchar(100) not null, \n" +
                "title varchar(100) not null, \n" +
                "price varchar(200) null, \n" +
                "author varchar(100) null, \n" +
                "publisher varchar(100) null, \n" +
                "category JSON null, \n" +
                "state JSON null, \n" +
                "trade_method varchar(100) null, \n" +
                "img JSON null, \n" +
                "sold varchar(1) null, \n" +
                "about varchar(100) null, \n" +
                "owner_id varchar(64) null \n" +
                ");";
        jdbcTemplate.execute(query);
    }

    @Test
    @DisplayName("유저는 새로운 책을 등록할 수 있다.")
    @Transactional
    public void handle() {
//        // given
//        BookMybatisService bookRepository = new BookMybatisService(dao);
//        IdentityMybatisService identityRepository = new IdentityMybatisService(dao, passwordEncoder);
//        RegisterBookCommandHandler sut = new RegisterBookCommandHandler(bookRepository, identityRepository);
//
//        CreateUserIdentityCommandHandler singUp = new CreateUserIdentityCommandHandler(identityRepository);
//
//        SignUpVO user = new SignUpVO(
//                "111",
//                "abcdefg@naver.com",
//                "aa",
//                "홍길동",
//                "길동이",
//                "010-1234-5678",
//                "좋아하는 추억",
//                "많은 추억"
//        );
//        singUp.handle(user);
//
//        List<String> checkCategory = new ArrayList<>();
//        checkCategory.add("SF");
//        checkCategory.add("만화");
//
//        List<String> checkState = new ArrayList<>();
//        checkState.add("깨끗");
//        checkState.add("거의 새책");
//
//        List<String> images = new ArrayList<>();
//        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
//        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");
//
//        RegisterBookVO registerBook = new RegisterBookVO(
//                "7777777",
//                "이 책 좋아",
//                "자바의 신",
//                "28000",
//                "김상민",
//                "실크로드 출판사",
//                checkCategory,
//                checkState,
//                images,
//                "직거래",
//                "0",
//                "자바 기본서 입니다.",
//                "abcdefg@naver.com",
//                "abcdefg@naver.com"
//        );
//
//        // when
//        RegisterBookVO actual = sut.handle(registerBook);
//
//        // then
//        assertThat(actual).isNotNull();
//        assertThat(actual.getPostmessage()).isEqualTo("이 책 좋아");
//        assertThat(actual.getTitle()).isEqualTo("자바의 신");
//        assertThat(actual.getPrice()).isEqualTo("28000");
//        assertThat(actual.getAuthor()).isEqualTo("김상민");
//        assertThat(actual.getPublisher()).isEqualTo("실크로드 출판사");
//        assertThat(actual.getCheckCategory()).contains("SF");
//        assertThat(actual.getCheckCategory()).contains("만화");
//        assertThat(actual.getCheckState()).contains("깨끗");
//        assertThat(actual.getCheckState()).contains("거의 새책");
//        assertThat(actual.getImages()).contains("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
//        assertThat(actual.getImages()).contains("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");
//        assertThat(actual.getDealRoot()).isEqualTo("직거래");
//        assertThat(actual.getSold()).isEqualTo("0");
//        assertThat(actual.getAbout()).isEqualTo("자바 기본서 입니다.");
//        assertThat(actual.getOwnerEmail()).isEqualTo("abcdefg@naver.com");
    }
}
