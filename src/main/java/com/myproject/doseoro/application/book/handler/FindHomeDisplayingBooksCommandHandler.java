package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.ICommandHandler;
import com.myproject.doseoro.domain.book.abstraction.IBookRepository;
import com.myproject.doseoro.domain.book.vo.HomeDisplayedBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindHomeDisplayingBooksCommandHandler implements ICommandHandler<Void, List<HomeDisplayedBookVO>> {

    private final IBookRepository service;

    @Logging
    @Override
    public List<HomeDisplayedBookVO> handle(Void unused) {
        List<HomeDisplayedBookVO> homeDisplayList = service.findHomeDisplayedBooks();

        return homeDisplayList;
    }
}
