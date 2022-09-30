package com.myproject.doseoro.application.abstraction;

import com.myproject.doseoro.application.book.vo.*;

import java.util.List;

public interface BookRepository {

    void registerBook(RegisterBookVO vo);

    public BookVO findBookByBookId(String bookId);

    public List<HomeDisplayedBookVO> findHomeDisplayedBooks();

    public List<FindAllBooksVO> findAllBooksForSaleBoard();

    public void hitLike(BookHitVO vo);

    public void hitReLikeWhenLiked(String userId, String bookId, String isLiked);

    public void hitReLikeWhenUnLiked(String userId, String bookId, String isLiked);

    public List<BookHitVO> isLikedByUserIdAndBookId(String userId, String bookId);

    public List<BookHitVO> countLike(String bookId);

    public String isBookLiked(String userId, String bookId);

    List<FindAllLikedBookVO> FindAllLikedBookByUserId(String userId);

    List<AllLikedBookVO> allLikedBook(String bookId);
}
