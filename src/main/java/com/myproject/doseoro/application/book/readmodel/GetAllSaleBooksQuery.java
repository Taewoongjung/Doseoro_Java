package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllSaleBooksResult;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllSaleBooksQuery implements CommandQuery<Void, GetAllSaleBooksResult> {

    private final BookRepository bookMybatisService;

    @Logging
    @Override
    public GetAllSaleBooksResult query(Void unused) {
        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForSaleBoard();

        return new GetAllSaleBooksResult(bookList);
    }
}
