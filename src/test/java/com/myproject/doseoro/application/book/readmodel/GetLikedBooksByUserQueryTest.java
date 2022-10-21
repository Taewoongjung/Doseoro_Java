package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetLikedBooksByUserQueryTest {

    @InjectMocks
    private GetLikedBooksByUserQuery getLikedBooksByUserQuery;

    @Mock
    private BookRepository bookMybatisRepository;

    @Mock
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("책을 찾으려고 하는 유저가 null이면 null을 반환한다.")
    void test1() {

        when(accessUserSessionManager.extractUser()).thenReturn(null);

        GetLikedBooksByUserDtoResult actual = getLikedBooksByUserQuery.query(null);

        assertThat(actual).isEqualTo(null);
    }

    @Test
    @DisplayName("유저 아이디로 좋아요 눌러진 책들을 찾을 수 있다.")
    void test2() {

        List<AllLikedBookVO> list = new ArrayList<>();
        list.add(new AllLikedBookVO("11434266", "123", "1212"));
        list.add(new AllLikedBookVO("25966067", "123", "121112"));

        when(accessUserSessionManager.extractUser()).thenReturn("123");
        when(bookMybatisRepository.allLikedBook("123")).thenReturn(list);

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
                .id("1212")
                .postMessage("책팝니다 ~")
                .title("재미있는 책")
                .price("100000")
                .author("난 천재")
                .publisher("출판사")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .tradeMethod("직거래")
                .sold("0")
                .about("재미있는 책 팜")
                .OwnerId("123")
                .build();

        BookVO registeredBook2 = BookVO.builder()
                .id("121112")
                .postMessage("이 책 팔아요")
                .title("재미있는 책")
                .price("100000")
                .author("천재")
                .publisher("출판사")
                .category(checkCategory)
                .state(checkState)
                .images(images)
                .tradeMethod("직거래")
                .sold("0")
                .about("재미있는 책 팜")
                .OwnerId("123")
                .build();

        when(bookMybatisRepository.findBookByBookId("1212")).thenReturn(registeredBook1);
        when(bookMybatisRepository.findBookByBookId("121112")).thenReturn(registeredBook2);

        GetLikedBooksByUserDtoResult actual = getLikedBooksByUserQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getLikedBooks().get(0).getId()).isEqualTo("1212");
        assertThat(actual.getLikedBooks().get(0).getPostMessage()).isEqualTo("책팝니다 ~");
        assertThat(actual.getLikedBooks().get(0).getOwnerId()).isEqualTo("123");

        assertThat(actual.getLikedBooks().get(1).getId()).isEqualTo("121112");
        assertThat(actual.getLikedBooks().get(1).getPostMessage()).isEqualTo("이 책 팔아요");
        assertThat(actual.getLikedBooks().get(1).getOwnerId()).isEqualTo("123");
    }
}