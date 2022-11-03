package com.myproject.doseoro.adaptor.infra.dao;

import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.application.identity.vo.LogInVO;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import org.apache.ibatis.annotations.Param;

public interface IdentityDao {

    Boolean existEmail(String email);

    IdentityMyPageVO findUserById(String id);

    AccessUserVO findUserByEmail(String email);

    SignUpVO findUser(String email);

    LogInVO loginCheck(@Param("email") String email);

    boolean signUp(SignUpVO user);
}
