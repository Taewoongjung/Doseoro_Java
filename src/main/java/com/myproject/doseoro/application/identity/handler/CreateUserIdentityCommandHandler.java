package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.domain.identity.abstraction.IIdentityRepository;
import com.myproject.doseoro.domain.identity.vo.SignUpVO;
import com.myproject.doseoro.application.global.error.exception.BusinessException;
import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.ICommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.myproject.doseoro.application.global.error.exception.ErrorCode.EMAIL_DUPLICATION;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler implements ICommandHandler<SignUpVO, Boolean> {

    private final IIdentityRepository repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Logging
    @Override
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
