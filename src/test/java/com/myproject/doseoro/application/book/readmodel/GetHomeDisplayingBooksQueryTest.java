package com.myproject.doseoro.application.book.readmodel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.application.book.vo.HomeDisplayedSaleBookVO;
import com.myproject.doseoro.book.HomeDisplayedSaleBookVOFixture;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetHomeDisplayingBooksQueryTest {

    @InjectMocks
    GetHomeDisplayingBooksQuery sut;

    @Mock
    private BookRepository repository;

    @Test
    @DisplayName("5개 이하의 판매 책을 조회한다.")
    void test1() {
        List<HomeDisplayedSaleBookVO> bookList
            = HomeDisplayedSaleBookVOFixture.homeDisplayedSaleBookVOList();

        when(repository.findHomeDisplayedSaleBooks()).thenReturn(bookList);

        List<HomeDisplayedSaleBookVO> actual = sut.query(null);

        assertThat(actual.get(0)).isNotNull();
        assertThat(actual.get(1)).isNotNull();
        assertThat(actual.get(2)).isNotNull();
        assertThat(actual.get(3)).isNotNull();
        assertThat(actual.get(4)).isNotNull();
    }

    @Test
    @DisplayName("6개 이상의 판매 책을 조회 하지 못한다.")
    void test2() {
        List<HomeDisplayedSaleBookVO> bookList
            = HomeDisplayedSaleBookVOFixture.homeDisplayedSaleBookVOList();

        when(repository.findHomeDisplayedSaleBooks()).thenReturn(bookList);

        List<HomeDisplayedSaleBookVO> actual = sut.query(null);

        assertThat(actual.get(0)).isNotNull();
        assertThat(actual.get(1)).isNotNull();
        assertThat(actual.get(2)).isNotNull();
        assertThat(actual.get(3)).isNotNull();
        assertThat(actual.get(4)).isNotNull();
        assertThat(actual.get(5)).isNull();
    }
}