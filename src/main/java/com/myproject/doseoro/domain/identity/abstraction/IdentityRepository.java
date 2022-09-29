package com.myproject.doseoro.domain.identity.abstraction;

import com.myproject.doseoro.domain.identity.vo.AccessUserVO;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.domain.identity.vo.IdentityVO;
import com.myproject.doseoro.domain.identity.vo.SignUpVO;

public interface IdentityRepository {
    public Boolean existEmail(String email);

    public IdentityMyPageVO findUserById(String id);

    public AccessUserVO findUserByEmail(String email);

    public SignUpVO findUser(String email);

    public boolean loginCheck(IdentityVO vo);

    public boolean signUp(SignUpVO user);
}
