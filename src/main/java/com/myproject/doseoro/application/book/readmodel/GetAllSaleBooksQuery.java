package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.book.dto.GetAllSaleBooksResult;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
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
