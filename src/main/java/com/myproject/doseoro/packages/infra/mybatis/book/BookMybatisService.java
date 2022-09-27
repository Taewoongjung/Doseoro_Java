package com.myproject.doseoro.packages.infra.mybatis.book;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.packages.book.vo.*;
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

    public void hitLike(BookHitVO vo) {
        dao.hitLike(vo);
    }

    public void hitReLikeWhenLiked(String userId, String bookId, String isLiked) {
        // 좋아요 눌러져 있을 때
        dao.hitReLikeWhenLiked(userId, bookId, isLiked);
    }

    public void hitReLikeWhenUnLiked(String userId, String bookId, String isLiked) {
        // 좋아요 안 눌러져 있을 때
        dao.hitReLikeWhenUnLiked(userId, bookId, isLiked);
    }

    public List<BookHitVO> isLikedByUserId(String userId, String bookId) {
        return dao.isLikedByUserId(userId, bookId);
    }

    public List<BookHitVO> countLike(String bookId) {
        return dao.countLike(bookId);
    }

    public String isBookLiked(String userId, String bookId) {
        return dao.isBookLiked(userId, bookId);
    }
}
