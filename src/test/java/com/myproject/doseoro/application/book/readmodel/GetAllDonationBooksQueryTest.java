package com.myproject.doseoro.application.book.readmodel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.application.book.dto.GetAllDonationBooksResult;
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
class GetAllDonationBooksQueryTest {

    @InjectMocks
    GetAllDonationBooksQuery getAllDonationBooksQuery;

    @Mock
    private BookRepository bookMybatisService;

    @Test
    @DisplayName("무료나눔 모든 책들을 불러온다.")
    void test() {
        FindAllBooksVO book1 = FindAllBooksVOFixture.firstDonationBook();

        FindAllBooksVO book2 = FindAllBooksVOFixture.secondDonationBook();

        List<FindAllBooksVO> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        when(bookMybatisService.findAllBooksForDonationBoard()).thenReturn(bookList);

        GetAllDonationBooksResult actual = getAllDonationBooksQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getBookList().get(0).getId()).isEqualTo("123");
        assertThat(actual.getBookList().get(0).getPostMessage()).isEqualTo("책 팔아요 ~");
        assertThat(actual.getBookList().get(0).getTitle()).isEqualTo("읽으면 좋은 책");
        assertThat(actual.getBookList().get(0).getAuthor()).isEqualTo("천재");
        assertThat(actual.getBookList().get(0).getPublisher()).isEqualTo("천재 모임");
        assertThat(actual.getBookList().get(0).getOwnerId()).isEqualTo("111");

        assertThat(actual.getBookList().get(1).getId()).isEqualTo("113");
        assertThat(actual.getBookList().get(1).getPostMessage()).isEqualTo("책 팜요 ~");
        assertThat(actual.getBookList().get(1).getTitle()).isEqualTo("읽으면 정말 좋은 책");
        assertThat(actual.getBookList().get(1).getAuthor()).isEqualTo("천재 작가");
        assertThat(actual.getBookList().get(1).getPublisher()).isEqualTo("천재 작가 모임");
        assertThat(actual.getBookList().get(1).getOwnerId()).isEqualTo("111");
    }
}