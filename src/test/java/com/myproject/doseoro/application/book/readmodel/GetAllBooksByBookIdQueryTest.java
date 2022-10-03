package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllBooksByBookIdQueryTest {

    @InjectMocks
    GetAllInformationOfTheBookByBookIdQuery getAllInformationOfTheBookByBookIdQuery;

    @Mock
    private BookRepository bookMybatisService;

    @Mock
    private IdentityRepository identityMybatisRepository;

    @Mock
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("해당 책의 id에 해당 하는 책의 모든 정보를 불러온다.")
    void test() {
        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        BookVO registeredBook1 = BookVO.builder()
                .id("777")
                .postMessage("책팝니다 ~")
                .title("정말 재미 있는 책")
                .price("100000")
                .author("난 천재")
                .publisher("출판사")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .tradeMethod("직거래")
                .sold("0")
                .about("재미있는 책 팜")
                .OwnerId("12312315256787")
                .build();

        IdentityMyPageVO registeredIdentity = new IdentityMyPageVO(
                "12312315256787",
                "a@a.com",
                "홍길동",
                "길도이",
                "010-2111-7777",
                "경기도 용인시 보정동",
                "보정동",
                "용인시",
                "경기도",
                "kakao",
                "12321-11",
                "11-11-11"
        );

        BookHitVO bookLikedList = new BookHitVO(
                "1111111",
                "12312315256787",
                "777",
                "t"
        );

        List<BookHitVO> countLikedInTheBook = new ArrayList<>();
        countLikedInTheBook.add(bookLikedList);

        when(bookMybatisService.findBookByBookId("777")).thenReturn(registeredBook1);
        when(identityMybatisRepository.findUserById("12312315256787")).thenReturn(registeredIdentity);
        when(accessUserSessionManager.extractUser()).thenReturn("12312315256787");
        when(bookMybatisService.countLike("777")).thenReturn(countLikedInTheBook);
        when(bookMybatisService.isBookLiked("12312315256787", "777")).thenReturn("true");

        GetAllInformationOfTheBookByBookIdDtoResult actual = getAllInformationOfTheBookByBookIdQuery.query(new GetAllInformationOfTheBookByBookIdDto("777"));

        assertThat(actual).isNotNull();
        assertThat(actual.getBook().getId()).isEqualTo("777");
        assertThat(actual.getBook().getTitle()).isEqualTo("정말 재미 있는 책");
        assertThat(actual.getBook().getOwnerId()).isEqualTo("12312315256787");

        assertThat(actual.getUser().getId()).isEqualTo("12312315256787");
        assertThat(actual.getUser().getEmail()).isEqualTo("a@a.com");
        assertThat(actual.getUser().getName()).isEqualTo("홍길동");

        assertThat(actual.getCountLikedInTheBook().size()).isEqualTo(1);
        assertThat(actual.getIsLikeExisted()).isEqualTo("true");
    }
}