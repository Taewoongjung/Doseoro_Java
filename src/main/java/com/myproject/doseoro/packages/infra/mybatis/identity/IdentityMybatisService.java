package com.myproject.doseoro.packages.infra.mybatis.identity;

import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.vo.AccessUser;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class IdentityMybatisService {
    /* 데이터베이스에서 값들을 받아 이 클래스에서 처리 후 넘기기 위한 클래스 */

    private final DoseoroDao dao;

    public Boolean existEmail(String email) {

        Boolean found = dao.existEmail(email);

        if (found == null) {
            found = false;
        }

        return found;
    }

    public AccessUser findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public SignUpVO findUser(String email) {
        return dao.findUser(email);
    }

    public boolean loginCheck(IdentityVO vo) {
        HashMap name = dao.loginCheck(vo.getEmail());
        System.out.println(name);
        return (name == null) ? false : true;
    }

    public boolean signUp(SignUpVO user) {
        return dao.signUp(user);
    }
}
