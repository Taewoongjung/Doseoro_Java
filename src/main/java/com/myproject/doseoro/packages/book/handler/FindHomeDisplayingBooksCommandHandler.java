package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.util.Logging;
import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindHomeDisplayingBooksCommandHandler implements ICommandHandler<Void, List<HomeDisplayedBookVO>> {

    private final BookMybatisService service;

    @Logging
    @Override
    public List<HomeDisplayedBookVO> handle(Void unused) {
        List<HomeDisplayedBookVO> homeDisplayList = service.findHomeDisplayedBooks();

        return homeDisplayList;
    }
}
