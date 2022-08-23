package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.infra.mybatis.IdentityMybatisRepository;
import com.myproject.doseoro.packages.identity.domain.Identity;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Component
@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler {

    private final IdentityMybatisRepository identityRepository;

    public Identity signUp(final SignUpRequest dto) throws Exception {
//        if (identityRepository.existsByEmail(dto.getEmail())) {
//            throw new Exception("email existed");
//        }

        final String uuid = UUID.randomUUID().toString();
        return identityRepository.save(dto, uuid);
    }

    public void findEmail(final SignUpRequest dto) throws Exception {
//        if (identityRepository.existsByEmail(dto.getEmail())) {
//            throw new Exception("email existed");
//        }
        identityRepository.existsByEmail();
        System.out.println("found");
    }
}
