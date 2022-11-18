package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBuyingBookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHomeDisplayingBuyingBooksQuery implements
    CommandQuery<Void, List<HomeDisplayedBuyingBookVO>> {

    private final BookRepository repository;

    @Logging
    @Override
    public List<HomeDisplayedBuyingBookVO> query(Void homeDisplayedBuyingBookVO) {

        List<HomeDisplayedBuyingBookVO> homeDisplayList = repository.findHomeDisplayedBuyingBooks();

        return homeDisplayList;
    }
}
