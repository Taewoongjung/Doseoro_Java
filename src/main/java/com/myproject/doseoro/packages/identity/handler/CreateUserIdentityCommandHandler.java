package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.myproject.doseoro.global.error.exception.ErrorCode.EMAIL_DUPLICATION;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler implements ICommandHandler<SignUpVO, Boolean> {

    private final IdentityMybatisService repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Boolean handle(final SignUpVO dto) {
        if (repository.existEmail(dto.getEmail())) {
            throw new BusinessException(EMAIL_DUPLICATION);
        }

        final String uuid = UUID.randomUUID().toString();
        dto.setId(uuid);

        String hashedPassword = encoder.encode(dto.getPassword());
        dto.setPassword(hashedPassword);

        boolean signUpCompleted = repository.signUp(dto);
        return signUpCompleted;
    }
}
