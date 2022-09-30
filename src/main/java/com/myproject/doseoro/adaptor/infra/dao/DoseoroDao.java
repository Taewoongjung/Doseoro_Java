package com.myproject.doseoro.adaptor.infra.dao;

import com.myproject.doseoro.application.book.vo.*;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.application.identity.vo.LogInVO;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoseoroDao {

// @@@@@@@@@@@@@@@@   identity     @@@@@@@@@@@@@@@@@

    Boolean existEmail(String email);

    IdentityMyPageVO findUserById(String id);

    AccessUserVO findUserByEmail(String email);

    SignUpVO findUser(String email);

    LogInVO loginCheck(@Param("email")String email);

    boolean signUp(SignUpVO user);





// @@@@@@@@@@@@@@@@   book     @@@@@@@@@@@@@@@@@
    void registerBook(@Param("vo") RegisterBookVO vo);

    BookVO findBookByBookId(String bookId);

    List<HomeDisplayedBookVO> findHomeDisplayedBooks();

    List<FindAllBooksVO> findAllBooksForSaleBoard();

    void hitLike(@Param("vo") BookHitVO vo);

    void hitReLikeWhenUnLiked(@Param("userId") String userId, @Param("bookId") String bookId, @Param("isLiked") String isLiked);

    void hitReLikeWhenLiked(@Param("userId") String userId, @Param("bookId") String bookId, @Param("isLiked") String isLiked);

    List<BookHitVO> isLikedByUserIdAndBookId(@Param("userId") String userId, @Param("bookId") String bookId);

    List<BookHitVO> countLike(String bookId);

    String isBookLiked(@Param("userId") String userId, @Param("bookId") String bookId);

    List<FindAllLikedBookVO> FindAllLikedBookByUserId(String userId);

    List<AllLikedBookVO> allLikedBook(String userId);
}
