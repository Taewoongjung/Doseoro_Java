package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(MockitoExtension.class)
class RegisterBuyingBookCommandHandlerTest {

    @InjectMocks
    private RegisterBuyingBookCommandHandler sut;
    @Mock
    private BookRepository repository;
    @Mock
    private IdentityRepository identityRepository;

    @Test
    @Transactional
    @DisplayName("유저는 책 삽니다를 등록할 수 있다.")
    void test() {
        
    }
}