package com.myproject.doseoro.adaptor.infra.mybatis.book;

import com.myproject.doseoro.adaptor.infra.dao.BookDao;
import com.myproject.doseoro.application.book.dto.BookReHitDto;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.application.book.vo.FindAllLikedBookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBuyingBookVO;
import com.myproject.doseoro.application.book.vo.HomeDisplayedDonationBookVO;
import com.myproject.doseoro.application.book.vo.HomeDisplayedSaleBookVO;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.domain.book.repository.BookRepository;
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
    public void registerBuyingBook(RegisterBookVO vo) {
        dao.registerBuyingBook(vo);
    }

    @Override
    public BookVO findBookByBookId(String bookId) {
        return dao.findBookByBookId(bookId);
    }

    @Override
    public BookVO findBuyingBookByBookId(String bookId) {
        return dao.findBuyingBookByBookId(bookId);
    }

    @Override
    public List<HomeDisplayedSaleBookVO> findHomeDisplayedSaleBooks() {
        return dao.findHomeDisplayedSaleBooks();
    }

    @Override
    public List<HomeDisplayedBuyingBookVO> findHomeDisplayedBuyingBooks() {
        return dao.findHomeDisplayedBuyingBooks();
    }

    @Override
    public List<HomeDisplayedDonationBookVO> findHomeDisplayedDonationBooks() {
        return dao.findHomeDisplayedDonationBooks();
    }

    @Override
    public List<FindAllBooksVO> findAllBooksForSaleBoard() {
        return dao.findAllBooksForSaleBoard();
    }

    @Override
    public List<FindAllBooksVO> findAllBooksForDonationBoard() {
        return dao.findAllBooksForDonationBoard();
    }

    @Override
    public List<FindAllBooksVO> findAllBooksForBuyingBoard() {
        return dao.findAllBooksForBuyingBoard();
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
    public List<BookHitVO> isLikedByUserIdAndBookId(BookHitVO vo) {
        return dao.isLikedByUserIdAndBookId(vo);
    }

    @Override
    public List<BookHitVO> countLike(String bookId) {
        return dao.countLike(bookId);
    }

    @Override
    public String isBookLiked(FindIfBookIsLikedVo vo) {
        return dao.isBookLiked(vo);
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
