package com.myproject.doseoro.application.identity.handler;

import static com.myproject.doseoro.adaptor.global.error.exception.ErrorCode.EMAIL_DUPLICATION;

import com.myproject.doseoro.adaptor.global.error.exception.BusinessException;
import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler implements CommandHandler<SignUpVO, Void> {

    private final IdentityRepository repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Logging
    @Override
    public Void handle(final SignUpVO vo) {
        if (Boolean.TRUE.equals(repository.existEmail(vo.getEmail()))) {
            throw new BusinessException(EMAIL_DUPLICATION);
        }

        vo.imbueUserId();

        String hashedPassword = encoder.encode(vo.getPassword());
        vo.imbueUserPassword(hashedPassword);
        repository.signUp(vo);
        
        return null;
    }
}
