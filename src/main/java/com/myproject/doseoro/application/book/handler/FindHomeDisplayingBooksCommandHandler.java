package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandHandler;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindHomeDisplayingBooksCommandHandler implements
    CommandHandler<Void, List<HomeDisplayedBookVO>> {

    private final BookRepository service;

    @Logging
    @Override
    public List<HomeDisplayedBookVO> handle(Void unused) {
        List<HomeDisplayedBookVO> homeDisplayList = service.findHomeDisplayedBooks();

        return homeDisplayList;
    }
}
