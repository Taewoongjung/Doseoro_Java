package com.myproject.doseoro.adaptor.infra.dao;

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

public interface BookDao {

    void registerBook(RegisterBookVO vo);

    void registerDonationBook(RegisterBookVO vo);

    BookVO findBookByBookId(String bookId);

    List<HomeDisplayedBookVO> findHomeDisplayedBooks();

    List<FindAllBooksVO> findAllBooksForSaleBoard();

    List<FindAllBooksVO> findAllBooksForDonationBoard();

    void hitLike(BookHitVO vo);

    void hitReLikeWhenUnLiked(BookReHitDto dto);

    void hitReLikeWhenLiked(BookReHitDto dto);

    List<BookHitVO> isLikedByUserIdAndBookId(BookHitVO vo);

    List<BookHitVO> countLike(String bookId);

    String isBookLiked(FindIfBookIsLikedVo vo);

    List<FindAllLikedBookVO> FindAllLikedBookByUserId(String userId);

    List<AllLikedBookVO> allLikedBook(String userId);

    void hitBook(String bookId);
}
