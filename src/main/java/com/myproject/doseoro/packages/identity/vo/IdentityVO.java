package com.myproject.doseoro.packages.identity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public IdentityVO(String id, String email, String password, String name, String nickName, String phone, String forgotPwQuestion, String forgotPwAnswer) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.forgotPwQuestion = forgotPwQuestion;
        this.forgotPwAnswer = forgotPwAnswer;
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
                '}';
    }
//    public IdentityVO viewUser(IdentityVO vo, IdentityMybatisService repository) {
//        System.out.println("view User = "+vo);
//        IdentityVO a = repository.findByEmail(vo.getEmail());
//        System.out.println("@@@@@@@@ = "+a);
//        return a;
//    }
}
