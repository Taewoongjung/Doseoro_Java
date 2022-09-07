package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticateUserCommandHandler implements ICommandHandler<IdentityVO, IdentityVO> {

    private final IdentityMybatisService repository;

    @Override
    public IdentityVO handle(IdentityVO vo) {

        boolean result = repository.loginCheck(vo);
        if (result) {
            IdentityVO a = repository.findByEmail(vo.getEmail());
            return a;
        }
        return null;
    }
}
