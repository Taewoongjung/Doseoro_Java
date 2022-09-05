package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.abstraction.IdentityService;
import com.myproject.doseoro.packages.identity.dto.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class AuthenticateUserCommandHandler extends IdentityService {

    private final IdentityMybatisService repository;

    public boolean handle(IdentityVO vo, HttpSession session) {
        System.out.println("handler");
        boolean result = repository.loginCheck(vo);
        if (result) {
            IdentityVO vo1 = viewUser(vo);
            session.setAttribute("email", vo1.getEmail());
            session.setAttribute("name", vo1.getName());
        }
        return result;
    }

    @Override
    public IdentityVO viewUser(IdentityVO vo) {
        return repository.findByEmail(vo.getEmail());
    }
}
