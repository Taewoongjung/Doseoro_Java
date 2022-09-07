package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateUserCommandHandler implements ICommandHandler<IdentityVO, IdentityVO> {

    private final IdentityMybatisService repository;

    @Override
    public IdentityVO handle(IdentityVO vo) {

        System.out.println("handler");
        boolean result = repository.loginCheck(vo);
        if (result) {
            return vo.viewUser(vo, repository);
        }
        return null;
    }
}
