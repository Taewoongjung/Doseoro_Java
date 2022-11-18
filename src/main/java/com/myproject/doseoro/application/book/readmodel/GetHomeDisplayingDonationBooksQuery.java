package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.vo.HomeDisplayedDonationBookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHomeDisplayingDonationBooksQuery implements
    CommandQuery<Void, List<HomeDisplayedDonationBookVO>> {

    private final BookRepository repository;

    @Logging
    @Override
    public List<HomeDisplayedDonationBookVO> query(Void homeDisplayedBuyingBookVO) {

        List<HomeDisplayedDonationBookVO> homeDisplayList = repository.findHomeDisplayedDonationBooks();

        return homeDisplayList;
    }
}
