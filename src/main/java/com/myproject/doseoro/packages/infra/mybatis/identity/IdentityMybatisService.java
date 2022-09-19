package com.myproject.doseoro.packages.infra.mybatis.identity;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.packages.identity.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.myproject.doseoro.global.error.exception.ErrorCode.EMAIL_NOT_MATCHED;
import static com.myproject.doseoro.global.error.exception.ErrorCode.PASSWORD_NOT_MATCHED;

@Service
@Slf4j
@RequiredArgsConstructor
public class IdentityMybatisService {
    /* 데이터베이스에서 값들을 받아 이 클래스에서 처리 후 넘기기 위한 클래스 */

    private final DoseoroDao dao;
    private final PasswordEncoder passwordEncoder;

    public Boolean existEmail(String email) {

        Boolean found = dao.existEmail(email);

        if (found == null) {
            found = false;
        }

        return found;
    }

    public IdentityMyPageVO findUserById(String id) {
        return dao.findUserById(id);
    }

    public AccessUserVO findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }

    public SignUpVO findUser(String email) {
        return dao.findUser(email);
    }

    public boolean loginCheck(IdentityVO vo) {
        LogInVO foundUserToBeCompared = dao.loginCheck(vo.getEmail());
        if (foundUserToBeCompared == null) {
            log.error("[LOGIN ERROR] Email is not matched");
            throw new BusinessException(EMAIL_NOT_MATCHED);
        }
        if (!passwordEncoder.matches(vo.getPassword(), foundUserToBeCompared.getPassword())) {
            log.error("[LOGIN ERROR] Password is not matched");
            throw new BusinessException(PASSWORD_NOT_MATCHED);
        }
        return true;
    }

    public boolean signUp(SignUpVO user) {
        return dao.signUp(user);
    }
}
