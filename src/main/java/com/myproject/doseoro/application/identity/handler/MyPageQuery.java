package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.identity.dto.MyPageDtoResult;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageQuery implements CommandQuery<Void, MyPageDtoResult> {

    private final AccessUserSessionManager accessUserSessionManager;
    private final IdentityMybatisRepository identityRepository;

    @Override
    public MyPageDtoResult query(Void unused) {
        String userId = accessUserSessionManager.extractUser();

        IdentityMyPageVO user = identityRepository.findUserById(userId);

        return new MyPageDtoResult(user);
    }
}
