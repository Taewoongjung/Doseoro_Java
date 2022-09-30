package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.domain.identity.abstraction.IdentityRepository;
import com.myproject.doseoro.domain.identity.vo.AccessUserVO;
import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.domain.identity.vo.IdentityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateUserCommandHandler implements CommandHandler<IdentityVO, Boolean> {

    private final IdentityRepository repository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Logging
    @Override
    public Boolean handle(IdentityVO vo) {
        repository.loginCheck(vo);
        AccessUserVO loggedInUser = repository.findUserByEmail(vo.getEmail());
        accessUserSessionManager.saveUser(loggedInUser);

        return true;
    }
}