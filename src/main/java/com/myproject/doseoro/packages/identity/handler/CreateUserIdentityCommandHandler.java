package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserIdentityCommandHandler {

    private final DoseoroDao dao;

//    public Identity signUp(final SignUpRequest dto) throws Exception {
////        if (identityRepository.existsByEmail(dto.getEmail())) {
////            throw new Exception("email existed");
////        }
//
//        final String uuid = UUID.randomUUID().toString();
////        return identityRepository.save(dto, uuid);
//        return new Identity();
//    }

    public void findThis() {
//        if (identityRepository.existsByEmail(dto.getEmail())) {
//            throw new Exception("email existed");
//        }
        System.out.println("start");
        ArrayList<String> list = dao.findAll();
        System.out.println(list);
        System.out.println("found");
    }
}
