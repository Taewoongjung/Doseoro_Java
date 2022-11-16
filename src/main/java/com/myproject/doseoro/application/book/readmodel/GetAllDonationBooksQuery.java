package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.application.book.dto.GetAllDonationBooksResult;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllDonationBooksQuery implements CommandQuery<Void, GetAllDonationBooksResult> {

    private final BookRepository bookMybatisService;

    @Override
    public GetAllDonationBooksResult query(Void unused) {
        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForDonationBoard();

        return new GetAllDonationBooksResult(bookList);
    }
}
