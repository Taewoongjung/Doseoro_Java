package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.identity.abstraction.IdentityRepository;
import com.myproject.doseoro.domain.identity.dto.GetUserInformationDtoResult;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserInformationQuery implements CommandQuery<Void, GetUserInformationDtoResult> {

    private final AccessUserSessionManager accessUserSessionManager;
    private final IdentityRepository identityRepository;

    @Override
    public GetUserInformationDtoResult query(Void unused) {
        String userId = accessUserSessionManager.extractUser();

        IdentityMyPageVO user = identityRepository.findUserById(userId);

        return new GetUserInformationDtoResult(user);
    }
}
