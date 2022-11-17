package com.myproject.doseoro.application.book.readmodel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.application.book.dto.GetAllBuyingBooksResult;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.book.FindAllBooksVOFixture;
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
class GetAllBuyingBooksQueryTest {

    @InjectMocks
    GetAllBuyingBooksQuery getAllBuyingBooksQuery;

    @Mock
    private BookRepository bookMybatisService;

    @Test
    @DisplayName("삽니다 등록된 것들 모두 불러온다.")
    void test() {
        FindAllBooksVO book1 = FindAllBooksVOFixture.firstBuyingBook();

        FindAllBooksVO book2 = FindAllBooksVOFixture.secondBuyingBook();

        List<FindAllBooksVO> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        when(bookMybatisService.findAllBooksForBuyingBoard()).thenReturn(bookList);

        GetAllBuyingBooksResult actual = getAllBuyingBooksQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getBookList().get(0).getId()).isEqualTo("123");
        assertThat(actual.getBookList().get(0).getPostMessage()).isEqualTo("책 사요 ~");
        assertThat(actual.getBookList().get(0).getTitle()).isEqualTo("읽으면 좋은 책");
        assertThat(actual.getBookList().get(0).getAuthor()).isEqualTo("천재");
        assertThat(actual.getBookList().get(0).getPublisher()).isEqualTo("천재 모임");
        assertThat(actual.getBookList().get(0).getCategory().get(0)).isEqualTo("SF");
        assertThat(actual.getBookList().get(0).getCategory().get(1)).isEqualTo("만화");
        assertThat(actual.getBookList().get(0).getOwnerId()).isEqualTo("111");

        assertThat(actual.getBookList().get(1).getId()).isEqualTo("125");
        assertThat(actual.getBookList().get(1).getPostMessage()).isEqualTo("책 사요 ~~");
        assertThat(actual.getBookList().get(1).getTitle()).isEqualTo("읽으면 좋은 책");
        assertThat(actual.getBookList().get(1).getAuthor()).isEqualTo("천재 작가");
        assertThat(actual.getBookList().get(1).getPublisher()).isEqualTo("천재 모임");
        assertThat(actual.getBookList().get(1).getCategory().get(0)).isEqualTo("SF");
        assertThat(actual.getBookList().get(1).getCategory().get(1)).isEqualTo("만화");
        assertThat(actual.getBookList().get(1).getOwnerId()).isEqualTo("111");
    }
}