package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.contract.abstraction.CommandHandler;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddHitWhenBookClickedCommandHandler implements CommandHandler<String, Void> {

    private final BookRepository bookRepository;

    @Logging
    @Override
    public Void handle(String bookId) {

        bookRepository.hitBook(bookId);

        return null;
    }
}
