package com.myproject.doseoro.packages.infra.mybatis.book;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.packages.book.vo.RegisterBookVO;
import com.myproject.doseoro.packages.book.vo.BookVO;
import com.myproject.doseoro.packages.book.vo.FindAllBooksVO;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookMybatisService {

    private final DoseoroDao dao;

    public void registerBook(RegisterBookVO vo) {
        dao.registerBook(vo);
    }

    public BookVO findBookByBookId(String bookId) {
        return dao.findBookByBookId(bookId);
    }

    public List<HomeDisplayedBookVO> findHomeDisplayedBooks() {
        return dao.findHomeDisplayedBooks();
    }

    public List<FindAllBooksVO> findAllBooksForSaleBoard() {
        return dao.findAllBooksForSaleBoard();
    }
}
