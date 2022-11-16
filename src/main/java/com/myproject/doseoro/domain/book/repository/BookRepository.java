package com.myproject.doseoro.domain.book.repository;

import com.myproject.doseoro.application.book.dto.BookReHitDto;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindAllBooksVO;
import com.myproject.doseoro.application.book.vo.FindAllLikedBookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import java.util.List;

public interface BookRepository {

    void registerBook(RegisterBookVO vo);

    void registerDonationBook(RegisterBookVO vo);

    public BookVO findBookByBookId(String bookId);

    public List<HomeDisplayedBookVO> findHomeDisplayedBooks();

    public List<FindAllBooksVO> findAllBooksForSaleBoard();

    public List<FindAllBooksVO> findAllBooksForDonationBoard();

    public void hitLike(BookHitVO vo);

    public void hitReLikeWhenLiked(BookReHitDto dto);

    public void hitReLikeWhenUnLiked(BookReHitDto dto);

    public List<BookHitVO> isLikedByUserIdAndBookId(BookHitVO vo);

    public List<BookHitVO> countLike(String bookId);

    public String isBookLiked(FindIfBookIsLikedVo vo);

    List<FindAllLikedBookVO> FindAllLikedBookByUserId(String userId);

    List<AllLikedBookVO> allLikedBook(String userId);

    void hitBook(String bookId);
}
