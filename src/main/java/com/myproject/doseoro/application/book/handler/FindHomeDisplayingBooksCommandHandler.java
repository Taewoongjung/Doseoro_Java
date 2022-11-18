package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.vo.HomeDisplayedSaleBookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandHandler;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindHomeDisplayingBooksCommandHandler implements
    CommandHandler<Void, List<HomeDisplayedSaleBookVO>> {

    private final BookRepository service;

    @Logging
    @Override
    public List<HomeDisplayedSaleBookVO> handle(Void unused) {
        List<HomeDisplayedSaleBookVO> homeDisplayList = service.findHomeDisplayedSaleBooks();

        return homeDisplayList;
    }
}
