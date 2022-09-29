package com.myproject.doseoro.adaptor.infra.mybatis.book;

import com.myproject.doseoro.adaptor.infra.dao.DoseoroDao;
import com.myproject.doseoro.domain.book.abstraction.IBookRepository;
import com.myproject.doseoro.domain.book.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookMybatisRepository implements IBookRepository {

    private final DoseoroDao dao;

    @Override
    public void registerBook(RegisterBookVO vo) {
        dao.registerBook(vo);
    }

    @Override
    public BookVO findBookByBookId(String bookId) {
        return dao.findBookByBookId(bookId);
    }

    @Override
    public List<HomeDisplayedBookVO> findHomeDisplayedBooks() {
        return dao.findHomeDisplayedBooks();
    }

    @Override
    public List<FindAllBooksVO> findAllBooksForSaleBoard() {
        return dao.findAllBooksForSaleBoard();
    }

    @Override
    public void hitLike(BookHitVO vo) {
        dao.hitLike(vo);
    }

    @Override
    public void hitReLikeWhenLiked(String userId, String bookId, String isLiked) {
        // 좋아요 눌러져 있을 때
        dao.hitReLikeWhenLiked(userId, bookId, isLiked);
    }

    @Override
    public void hitReLikeWhenUnLiked(String userId, String bookId, String isLiked) {
        // 좋아요 안 눌러져 있을 때
        dao.hitReLikeWhenUnLiked(userId, bookId, isLiked);
    }

    @Override
    public List<BookHitVO> isLikedByUserId(String userId, String bookId) {
        return dao.isLikedByUserId(userId, bookId);
    }

    @Override
    public List<BookHitVO> countLike(String bookId) {
        return dao.countLike(bookId);
    }

    @Override
    public String isBookLiked(String userId, String bookId) {
        return dao.isBookLiked(userId, bookId);
    }
}
