package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

import static com.myproject.doseoro.global.error.exception.ErrorCode.EMAIL_DUPLICATION;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler {

    private final IdentityMybatisService repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean handle(final SignUpRequest dto) {
        if (repository.existEmail(dto.getEmail())) {
            throw new BusinessException(EMAIL_DUPLICATION);
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
}
