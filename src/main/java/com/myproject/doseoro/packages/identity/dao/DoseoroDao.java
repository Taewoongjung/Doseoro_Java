package com.myproject.doseoro.packages.identity.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface DoseoroDao {
    ArrayList<String> findAll();
}
