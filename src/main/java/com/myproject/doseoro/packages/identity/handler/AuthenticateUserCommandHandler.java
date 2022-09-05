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

    private SqlSession sqlSession;
    private final IdentityMybatisService repository;

    public boolean handle(IdentityVO vo, HttpSession session) {
        System.out.println("handler");
        boolean result = repository.loginCheck(vo);
        if (result) {
            IdentityVO vo1 = viewUser(vo);
            System.out.println("in if phrase");
            System.out.println(vo1);
            session.setAttribute("email", vo1.getEmail());
        }
        System.out.println("return from handler");
        return result;
    }

    @Override
    public IdentityVO viewUser(IdentityVO vo) {
        System.out.println("viewUser in");
        return repository.findByEmail(vo.getEmail());
    }
}
