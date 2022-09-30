package com.myproject.doseoro.application.identity.vo;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Getter
public class IdentityVO {
    private final String id;
    private final String email;
    private final String password;
    private final String name;
    private final String nickName;
    private final String phone;
    private final String forgotPwQuestion;
    private final String forgotPwAnswer;

    private final HttpServletResponse response;

    public IdentityVO(String id, String email, String password, String name, String nickName, String phone, String forgotPwQuestion, String forgotPwAnswer, HttpServletResponse response) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.forgotPwQuestion = forgotPwQuestion;
        this.forgotPwAnswer = forgotPwAnswer;
        this.response = response;
    }

    @Override
    public String toString() {
        return "IdentityVO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", forgotPwQuestion='" + forgotPwQuestion + '\'' +
                ", forgotPwAnswer='" + forgotPwAnswer + '\'' +
                ", response=" + response +
                '}';
    }

    //    public IdentityVO viewUser(IdentityVO vo, IdentityMybatisService repository) {
//        System.out.println("view User = "+vo);
//        IdentityVO a = repository.findByEmail(vo.getEmail());
//        System.out.println("@@@@@@@@ = "+a);
//        return a;
//    }
}
