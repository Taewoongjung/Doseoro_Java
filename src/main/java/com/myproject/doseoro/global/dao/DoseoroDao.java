package com.myproject.doseoro.global.dao;

import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.identity.vo.AccessUser;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface DoseoroDao {

// @@@@@@@@@@@@@@@@   identity     @@@@@@@@@@@@@@@@@

    Boolean existEmail(String email);

    AccessUser findByEmail(String email);

    SignUpVO findUser(String email);

    HashMap loginCheck(@Param("email")String email);

    boolean signUp(SignUpVO user);

// @@@@@@@@@@@@@@@@   book     @@@@@@@@@@@@@@@@@
    void registerBook(@Param("dto")RegisterBookDTO dto);
}
