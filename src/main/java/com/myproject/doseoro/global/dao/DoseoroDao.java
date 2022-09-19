package com.myproject.doseoro.global.dao;

import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.book.vo.BookVO;
import com.myproject.doseoro.packages.book.vo.FindAllBooksVO;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.identity.vo.AccessUserVO;
import com.myproject.doseoro.packages.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DoseoroDao {

// @@@@@@@@@@@@@@@@   identity     @@@@@@@@@@@@@@@@@

    Boolean existEmail(String email);

    IdentityMyPageVO findUserById(String id);

    AccessUserVO findUserByEmail(String email);

    SignUpVO findUser(String email);

    HashMap loginCheck(@Param("email")String email);

    boolean signUp(SignUpVO user);

// @@@@@@@@@@@@@@@@   book     @@@@@@@@@@@@@@@@@
    void registerBook(@Param("dto")RegisterBookDTO dto);

    BookVO findBookByBookId(String bookId);

    List<HomeDisplayedBookVO> findHomeDisplayedBooks();

    List<FindAllBooksVO> findAllBooksForSaleBoard();
}
