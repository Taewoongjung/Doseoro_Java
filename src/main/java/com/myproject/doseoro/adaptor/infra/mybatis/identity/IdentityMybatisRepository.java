package com.myproject.doseoro.adaptor.infra.mybatis.identity;

import static com.myproject.doseoro.adaptor.global.error.exception.ErrorCode.EMAIL_NOT_MATCHED;
import static com.myproject.doseoro.adaptor.global.error.exception.ErrorCode.PASSWORD_NOT_MATCHED;

import com.myproject.doseoro.adaptor.global.error.exception.BusinessException;
import com.myproject.doseoro.adaptor.infra.dao.IdentityDao;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.application.identity.vo.IdentityVO;
import com.myproject.doseoro.application.identity.vo.LogInVO;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class IdentityMybatisRepository implements IdentityRepository {
    /* 데이터베이스에서 값들을 받아 이 클래스에서 처리 후 넘기기 위한 클래스 */

    private final IdentityDao dao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean existEmail(String email) {

        Boolean found = dao.existEmail(email);

        if (found == null) {
            found = false;
        }

        return found;
    }

    @Override
    public IdentityMyPageVO findUserById(String id) {
        return dao.findUserById(id);
    }

    @Override
    public AccessUserVO findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }

    @Override
    public SignUpVO findUser(String email) {
        return dao.findUser(email);
    }

    @Override
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

    @Override
    public boolean signUp(SignUpVO user) {
        return dao.signUp(user);
    }
}
