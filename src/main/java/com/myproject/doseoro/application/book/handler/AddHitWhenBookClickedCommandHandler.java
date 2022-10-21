package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddHitWhenBookClickedCommandHandler implements CommandHandler<String,Void> {

    private final BookRepository bookRepository;

    @Override
    public Void handle(String bookId) {

        bookRepository.hitBook(bookId);

        return null;
    }
}
