package com.myproject.doseoro.packages.identity.dao;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

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

    @Column(name = "forgot_pw_question", length = 100, nullable = false)
    private String forgotPwQuestion;

    @Column(name = "forgot_pw_answer", length = 100, nullable = false)
    private String forgotPwAnswer;

    @Column(length = 100, nullable = true)
    private String liked;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(length = 10, nullable = false)
    private String dong;

    @Column(length = 10, nullable = false)
    private String si;

    @Column(length = 10, nullable = false)
    private String dou;

    @Column(length = 100, nullable = false)
    private String provider;

    @Column(length = 50, nullable = true)
    private String snsId;
}
