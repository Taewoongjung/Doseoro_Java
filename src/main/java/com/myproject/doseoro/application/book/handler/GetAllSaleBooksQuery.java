package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.abstraction.BookRepository;
import com.myproject.doseoro.domain.book.dto.GetAllSaleBooksResult;
import com.myproject.doseoro.domain.book.vo.FindAllBooksVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllSaleBooksQuery implements CommandQuery<Void, GetAllSaleBooksResult> {

    private final BookRepository bookMybatisService;

    @Override
    public GetAllSaleBooksResult query(Void unused) {
        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForSaleBoard();

        return new GetAllSaleBooksResult(bookList);
    }
}
