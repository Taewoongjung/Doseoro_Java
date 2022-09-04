package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.domain.Identity;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler {

    private final IdentityMybatisService repository;

    public boolean signUp(final SignUpRequest dto) throws Exception {
        System.out.println("t or f"+repository.existEmail(dto.getEmail()));
        if (repository.existEmail(dto.getEmail())) { // 따로 예외 처리하기 (지금은 임시방편)
            throw new Exception("email existed");
        }

        final String uuid = UUID.randomUUID().toString();
        dto.id = uuid;
        System.out.println(dto);

        boolean done = repository.signUp(dto);
        System.out.println("Sign up done = " + done);
        return done;
    }

    public void findThis() {
//        if (identityRepository.existsByEmail(dto.getEmail())) {
//            throw new Exception("email existed");
//        }
        System.out.println("start");
        ArrayList<String> list = repository.findAll();
        System.out.println(list);
        System.out.println("found");
    }

    public void emailExist() {
        System.out.println("start");
        boolean found = repository.existEmail("a@a");
        System.out.println(found);
        System.out.println("found");
    }
}
