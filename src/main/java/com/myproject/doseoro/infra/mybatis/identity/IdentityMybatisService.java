package com.myproject.doseoro.infra.mybatis.identity;

import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.dto.IdentityDto;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.dto.vo.IdentityVO;
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

    public boolean signUp(SignUpRequest user) {
        return dao.signUp(user);
    }

    public IdentityVO findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public IdentityDto login(String email, String password) {
        return dao.login(email, password);
    }

    public Boolean loginCheck(IdentityVO vo) {
        System.out.println("loginCheck");
        System.out.println("loginCheck vo = " + vo);
        System.out.println("loginCheck vo = " + vo.getEmail());
        System.out.println("loginCheck vo = " + vo.getPassword());
//        Boolean name = dao.loginCheck(vo.getEmail(), vo.getPassword());
        HashMap name = dao.loginCheck(vo.getEmail());
        System.out.println("?? = " + name);
        return (name == null) ? false : true;
    }
}
