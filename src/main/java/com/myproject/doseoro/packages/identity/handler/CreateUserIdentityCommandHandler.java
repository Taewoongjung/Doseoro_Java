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

    public Boolean handle(final SignUpVO vo) {
        if (repository.existEmail(vo.getEmail())) {
            throw new BusinessException(EMAIL_DUPLICATION);
        }

        vo.imbueUserId();

        String hashedPassword = encoder.encode(vo.getPassword());
        vo.imbueUserPassword(hashedPassword);

        return repository.signUp(vo);
    }
}
