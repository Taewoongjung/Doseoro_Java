package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler {

    private final IdentityMybatisService repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean signUp(final SignUpRequest dto) throws Exception {
        if (repository.existEmail(dto.getEmail())) { // 따로 예외 처리하기 (지금은 임시방편)
            return false;
        }

        final String uuid = UUID.randomUUID().toString();
        dto.setId(uuid);

        String hashedPassword = encoder.encode(dto.getPassword());
        dto.setPassword(hashedPassword);

        System.out.println(dto);

        boolean signUpCompleted = repository.signUp(dto);
        System.out.println("Sign up signUpCompleted = " + signUpCompleted);
        return signUpCompleted;
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
        Boolean found = repository.existEmail("a@a");
        System.out.println(found);
        System.out.println("found");
    }
}
