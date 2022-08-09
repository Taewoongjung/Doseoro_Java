package com.myproject.doseoro.packages.identity.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_identity")
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(length = 200, nullable = false)
    private String id;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(name = "nick_name", length = 25, nullable = false)
    private String nickName;

    @Column(length = 14, nullable = false)
    private String phone;

    @Column(name = "forgot_pw_question", length = 100, nullable = true)
    private String forgotPwQuestion;

    @Column(name = "forgot_pw_answer", length = 100, nullable = true)
    private String forgotPwAnswer;

    @Column(length = 100, nullable = true)
    private String liked;

    @Column(length = 100, nullable = true)
    private String location;

    @Column(length = 10, nullable = true)
    private String dong;

    @Column(length = 10, nullable = true)
    private String si;

    @Column(length = 10, nullable = true)
    private String dou; // 도 ex) 경기"도"

    @Column(length = 100, nullable = true)
    private String provider;

    @Column(length = 50, nullable = true)
    private String snsId;
}
