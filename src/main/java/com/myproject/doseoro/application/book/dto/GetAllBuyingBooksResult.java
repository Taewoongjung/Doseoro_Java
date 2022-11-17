package com.myproject.doseoro.application.book.dto;

import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GetAllBuyingBooksResult {

    private final List<FindAllBooksVO> bookList;
}
