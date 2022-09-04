package com.myproject.doseoro.packages.identity.dao;

import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface DoseoroDao {
    ArrayList<String> findAll();

    Boolean existEmail(String email);

    boolean signUp(SignUpRequest user);
}
