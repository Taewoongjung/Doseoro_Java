package com.myproject.doseoro.application.identity.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.application.identity.dto.GetUserInformationDtoResult;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
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
