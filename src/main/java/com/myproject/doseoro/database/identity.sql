CREATE TABLE `t_identity`
(
    `seq`                    BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `id`                     VARCHAR(64)  NOT NULL COMMENT '유저 id',
    `email`                  VARCHAR(200) NOT NULL COMMENT '유저 email',
    `password`               VARCHAR(200) NOT NULL COMMENT '유저 패스워드',
    `name`                   VARCHAR(20)  NOT NULL COMMENT '유저 이름',
    `nick_name`              VARCHAR(25)  NOT NULL COMMENT '유저 닉네임',
    `phone`                  VARCHAR(14)  NOT NULL COMMENT '유저 휴대폰번호',
    `forgot_pw_question`     VARCHAR(100) NOT NULL COMMENT '비밀번호 분실 시 인증을 위한 질문',
    `forgot_pw_answer`       VARCHAR(100) NOT NULL COMMENT '비밀번호 분실 시 인증을 위한 질문에 대한 답',
    `liked`                  VARCHAR(100)     NULL COMMENT '좋아요 받은 개수',
    `location`               VARCHAR(100)     NULL COMMENT '유저가 사는 주소 전체',
    `dong`                   VARCHAR(10)      NULL COMMENT '유저가 사는 주소에서 동',
    `si`                     VARCHAR(10)      NULL COMMENT '유저가 사는 주소에서 시',
    `dou`                    VARCHAR(10)      NULL COMMENT '유저가 사는 주소에서 도',
    `provider`               VARCHAR(100)     NULL COMMENT '유저가 어떤 방식으로 회원가입 했는지 ex) local, google, kakao ...',
    `sns_id`                 VARCHAR(50)      NULL COMMENT '외부 서비스로(google, kakao ... )회원가입 할 때 찍히는 id',
    `created_at`             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`seq`),
    UNIQUE KEY `uix-identity-id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '회원가입';
