package com.myproject.doseoro.adaptor.infra.mybatis.book;

import com.myproject.doseoro.adaptor.infra.dao.BookDao;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.book.dto.BookReHitDto;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.application.book.vo.FindAllLikedBookVO;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookMybatisRepository implements BookRepository {

    private final BookDao dao;

    @Override
    public void registerBook(RegisterBookVO vo) {
        dao.registerBook(vo);
    }

    @Override
    public void registerDonationBook(RegisterBookVO vo) {
        dao.registerDonationBook(vo);
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
    public void hitReLikeWhenLiked(BookReHitDto dto) {
        // 좋아요 눌러져 있을 때
        dao.hitReLikeWhenLiked(dto);
    }

    @Override
    public void hitReLikeWhenUnLiked(BookReHitDto dto) {
        // 좋아요 안 눌러져 있을 때
        dao.hitReLikeWhenUnLiked(dto);
    }

    @Override
    public List<BookHitVO> isLikedByUserIdAndBookId(String userId, String bookId) {
        return dao.isLikedByUserIdAndBookId(userId, bookId);
    }

    @Override
    public List<BookHitVO> countLike(String bookId) {
        return dao.countLike(bookId);
    }

    @Override
    public String isBookLiked(String userId, String bookId) {
        return dao.isBookLiked(userId, bookId);
    }

    @Override
    public List<FindAllLikedBookVO> FindAllLikedBookByUserId(String userId) {
        return dao.FindAllLikedBookByUserId(userId);
    }

    @Override
    public List<AllLikedBookVO> allLikedBook(String userId) {
        return dao.allLikedBook(userId);
    }

    @Override
    public void hitBook(String bookId) {
        dao.hitBook(bookId);
    }
}
