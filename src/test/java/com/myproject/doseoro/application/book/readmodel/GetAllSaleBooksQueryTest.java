package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.application.book.dto.GetAllSaleBooksResult;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.book.FindAllBooksVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllSaleBooksQueryTest {

    @InjectMocks
    GetAllSaleBooksQuery getAllSaleBooksQuery;

    @Mock
    private BookRepository bookMybatisService;

    @Test
    @DisplayName("판매중인 모든 책들을 불러온다.")
    void test1() {

        FindAllBooksVO book1 = FindAllBooksVOFixture.firstFindAllBooksVO();

        FindAllBooksVO book2 = FindAllBooksVOFixture.secondFindAllBooksVO();

        List<FindAllBooksVO> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        when(bookMybatisService.findAllBooksForSaleBoard()).thenReturn(bookList);

        GetAllSaleBooksResult actual = getAllSaleBooksQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getBookList().get(0).getId()).isEqualTo("123");
        assertThat(actual.getBookList().get(0).getPostMessage()).isEqualTo("책 팔아요 ~");
        assertThat(actual.getBookList().get(0).getTitle()).isEqualTo("읽으면 좋은 책");
        assertThat(actual.getBookList().get(0).getPrice()).isEqualTo("70000000000000");
        assertThat(actual.getBookList().get(0).getAuthor()).isEqualTo("천재");
        assertThat(actual.getBookList().get(0).getPublisher()).isEqualTo("천재 모임");
        assertThat(actual.getBookList().get(0).getOwnerId()).isEqualTo("111");

        assertThat(actual.getBookList().get(1).getId()).isEqualTo("113");
        assertThat(actual.getBookList().get(1).getPostMessage()).isEqualTo("책 팜요 ~");
        assertThat(actual.getBookList().get(1).getTitle()).isEqualTo("읽으면 정말 좋은 책");
        assertThat(actual.getBookList().get(1).getPrice()).isEqualTo("7000000");
        assertThat(actual.getBookList().get(1).getAuthor()).isEqualTo("천재 작가");
        assertThat(actual.getBookList().get(1).getPublisher()).isEqualTo("천재 작가 모임");
        assertThat(actual.getBookList().get(1).getOwnerId()).isEqualTo("111");
    }

    @Test
    @DisplayName("판매중이지 않는 책(무료나눔)은 불러오지 않는다.")
    void test2() {

        FindAllBooksVO book1 = FindAllBooksVOFixture.notForSaleFindAllBooksVO();

        FindAllBooksVO book2 = FindAllBooksVOFixture.secondFindAllBooksVO();

        List<FindAllBooksVO> bookList = new ArrayList<>();
        bookList.add(null);
        bookList.add(book2);

        when(bookMybatisService.findAllBooksForSaleBoard()).thenReturn(bookList);

        GetAllSaleBooksResult actual = getAllSaleBooksQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getBookList().get(0)).isNull();

        assertThat(actual.getBookList().get(1).getId()).isEqualTo("113");
        assertThat(actual.getBookList().get(1).getPostMessage()).isEqualTo("책 팜요 ~");
        assertThat(actual.getBookList().get(1).getTitle()).isEqualTo("읽으면 정말 좋은 책");
        assertThat(actual.getBookList().get(1).getPrice()).isEqualTo("7000000");
        assertThat(actual.getBookList().get(1).getAuthor()).isEqualTo("천재 작가");
        assertThat(actual.getBookList().get(1).getPublisher()).isEqualTo("천재 작가 모임");
        assertThat(actual.getBookList().get(1).getOwnerId()).isEqualTo("111");
    }
}