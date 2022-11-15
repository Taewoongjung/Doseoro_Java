package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetAllSaleBooksResult {

    private final List<FindAllBooksVO> bookList;
}
