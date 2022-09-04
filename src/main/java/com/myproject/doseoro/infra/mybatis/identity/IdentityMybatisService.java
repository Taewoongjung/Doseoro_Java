package com.myproject.doseoro.infra.mybatis.identity;

import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
