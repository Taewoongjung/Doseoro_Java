package com.myproject.doseoro.application.book.readmodel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.book.BookVOFixture;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        list.add(new AllLikedBookVO("11434266", "12312315256787", "777"));
        list.add(new AllLikedBookVO("25966067", "12312315256787", "121112"));

        when(accessUserSessionManager.extractUser()).thenReturn("12312315256787");
        when(bookMybatisRepository.allLikedBook("12312315256787")).thenReturn(list);

        BookVO registeredBook1 = BookVOFixture.firstBookVO();

        BookVO registeredBook2 = BookVOFixture.secondBookVO();

        when(bookMybatisRepository.findBookByBookId("777")).thenReturn(registeredBook1);
        when(bookMybatisRepository.findBookByBookId("121112")).thenReturn(registeredBook2);

        GetLikedBooksByUserDtoResult actual = getLikedBooksByUserQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getLikedBooks().get(0).getId()).isEqualTo("777");
        assertThat(actual.getLikedBooks().get(0).getPostMessage()).isEqualTo("책팝니다 ~");
        assertThat(actual.getLikedBooks().get(0).getOwnerId()).isEqualTo("12312315256787");

        assertThat(actual.getLikedBooks().get(1).getId()).isEqualTo("121112");
        assertThat(actual.getLikedBooks().get(1).getPostMessage()).isEqualTo("이 책 팔아요");
        assertThat(actual.getLikedBooks().get(1).getOwnerId()).isEqualTo("12312315256787");
    }
}