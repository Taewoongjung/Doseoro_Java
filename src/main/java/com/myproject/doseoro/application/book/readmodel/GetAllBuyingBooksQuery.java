package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllBuyingBooksResult;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllBuyingBooksQuery implements CommandQuery<Void, GetAllBuyingBooksResult> {

    private final BookRepository bookMybatisService;

    @Logging
    @Override
    public GetAllBuyingBooksResult query(Void unused) {

        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForBuyingBoard();
        
        return new GetAllBuyingBooksResult(bookList);
    }
}
