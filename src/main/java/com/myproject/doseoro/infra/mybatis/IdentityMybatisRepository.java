package com.myproject.doseoro.infra.mybatis;

import com.myproject.doseoro.packages.identity.domain.Identity;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface IdentityMybatisRepository {
    @Insert(
            "INSERT into t_identity " +
                    "VALUES(" +
                        "${name}, " +
                        "${phoneNumber}, " +
                        "${nickName}, " +
                        "${email}, " +
                        "${password}, " +
                        "${question}, " +
                        "${answerForQuestion}" +
                    ")"
    )
    Identity save(SignUpRequest dto, String uuid);

//    @Select(
//            "SELECT email " +
//            "FROM t_identity " +
//            "WHERE email=${email}"
//    )
//    boolean existsByEmail(@Param("email") String email);
        boolean existsByEmail();

}
