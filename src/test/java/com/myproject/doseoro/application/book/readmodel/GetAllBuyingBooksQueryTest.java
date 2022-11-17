package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.domain.book.repository.BookRepository;
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

    }
}