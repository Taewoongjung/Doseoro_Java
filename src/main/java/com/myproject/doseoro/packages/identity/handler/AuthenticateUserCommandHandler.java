package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.identity.vo.AccessUserVO;
import com.myproject.doseoro.packages.infra.session.AccessUserSessionManager;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateUserCommandHandler implements ICommandHandler<IdentityVO, Boolean> {

    private final IdentityMybatisService repository;

    private final AccessUserSessionManager accessUserSessionManager;

    @Override
    public Boolean handle(IdentityVO vo) {

        boolean result = repository.loginCheck(vo);
        if (result) {
            AccessUserVO user = repository.findUserByEmail(vo.getEmail());
            accessUserSessionManager.saveUser(user);
            return true;
        }
        return false;
    }
}
