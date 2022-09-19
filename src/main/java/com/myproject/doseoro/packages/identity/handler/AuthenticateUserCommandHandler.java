package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.identity.vo.AccessUserVO;
import com.myproject.doseoro.packages.infra.session.AccessUserSessionManager;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.myproject.doseoro.global.error.exception.ErrorCode.EMAIL_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class AuthenticateUserCommandHandler implements ICommandHandler<IdentityVO, Boolean> {

    private final IdentityMybatisService repository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Override
    public Boolean handle(IdentityVO vo) {

        if(!repository.loginCheck(vo)) {
            throw new BusinessException(EMAIL_NOT_MATCHED);
        }

        AccessUserVO loggedInUser = repository.findUserByEmail(vo.getEmail());
        accessUserSessionManager.saveUser(loggedInUser);
        return true;
    }
}
