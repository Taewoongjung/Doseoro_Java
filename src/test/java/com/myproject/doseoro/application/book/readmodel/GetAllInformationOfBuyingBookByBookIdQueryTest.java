package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllInformationOfBuyingBookByBookIdQueryTest {

    @InjectMocks
    private GetAllInformationOfBuyingBookByBookIdQuery sut;

    @Mock
    private BookRepository bookMybatisService;
    @Mock
    private IdentityRepository repository;

    @Test
    @DisplayName("모든 삽니다 정보를 조회한다.")
    void test() {
        
    }
}