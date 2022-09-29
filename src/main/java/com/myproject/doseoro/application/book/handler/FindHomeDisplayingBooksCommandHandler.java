package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.domain.book.abstraction.BookRepository;
import com.myproject.doseoro.domain.book.vo.HomeDisplayedBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindHomeDisplayingBooksCommandHandler implements CommandHandler<Void, List<HomeDisplayedBookVO>> {

    private final BookRepository service;

    @Logging
    @Override
    public List<HomeDisplayedBookVO> handle(Void unused) {
        List<HomeDisplayedBookVO> homeDisplayList = service.findHomeDisplayedBooks();

        return homeDisplayList;
    }
}
