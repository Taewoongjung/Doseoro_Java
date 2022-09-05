package com.myproject.doseoro.packages.identity.dao;

import com.myproject.doseoro.packages.identity.dto.IdentityDto;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.dto.vo.IdentityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface DoseoroDao {
    Boolean existEmail(String email);

    IdentityVO findByEmail(String email);

    SignUpRequest findUser(String email);

    HashMap loginCheck(@Param("email")String email);

    boolean signUp(SignUpRequest user);
}
