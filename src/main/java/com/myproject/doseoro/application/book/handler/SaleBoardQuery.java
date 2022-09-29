package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.dto.SaleBoardDtoResult;
import com.myproject.doseoro.domain.book.vo.FindAllBooksVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleBoardQuery implements CommandQuery<Void, SaleBoardDtoResult> {

    private final BookMybatisRepository bookMybatisService;

    @Override
    public SaleBoardDtoResult query(Void unused) {
        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForSaleBoard();

        return new SaleBoardDtoResult(bookList);
    }
}
