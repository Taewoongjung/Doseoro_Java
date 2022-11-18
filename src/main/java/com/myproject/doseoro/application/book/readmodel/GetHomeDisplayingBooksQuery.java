package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.vo.HomeDisplayedSaleBookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHomeDisplayingBooksQuery implements
    CommandQuery<Void, List<HomeDisplayedSaleBookVO>> {

    private final BookRepository repository;

    @Logging
    @Override
    public List<HomeDisplayedSaleBookVO> query(Void unused) {
        List<HomeDisplayedSaleBookVO> homeDisplayList = repository.findHomeDisplayedSaleBooks();

        return homeDisplayList;
    }
}
