CREATE TABLE `t_book`
(
    `seq`           BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `id`            VARCHAR(64)  NOT NULL                  COMMENT '책 id',
    `post_message`  VARCHAR(100) NOT NULL                  COMMENT '책 포스팅 메시지',
    `title`         VARCHAR(100) NOT NULL                  COMMENT '책 제목',
    `price`         VARCHAR(200)     NULL   DEFAULT NULL   COMMENT '책 가격',
    `author`        VARCHAR(100)     NULL   DEFAULT NULL   COMMENT '책 저자 이름',
    `publisher`     VARCHAR(100)     NULL   DEFAULT NULL   COMMENT '책 출판사 이름',
    `category`      JSON             NULL   DEFAULT NULL   COMMENT '책 카테고리 이름',
    `state`         JSON             NULL   DEFAULT NULL   COMMENT '책 상태',
    `trade_method`  VARCHAR(100)     NULL   DEFAULT NULL   COMMENT '책 거래 방법',
    `img`           JSON             NULL   DEFAULT NULL   COMMENT '책 이미지(표지, 내부 상태 사진)',
    `sold`          TINYINT(1)       NULL   DEFAULT 0      COMMENT '해당 책이 팔렸는지 아닌지',
    `about`         VARCHAR(100)     NULL   DEFAULT NULL   COMMENT '해당 책에 대한 설명',
    `hits`          VARCHAR(200)     NULL   DEFAULT 0      COMMENT '해당 책의 조회수',
    `createdAt`     TIMESTAMP    NOT NULL   DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP    NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `owner_id`      VARCHAR(64)  NOT NULL                  COMMENT '해당 책을 소유하고 있는 사람의 id',
    PRIMARY KEY (`seq`),
    UNIQUE KEY `uix-book-id` (`id`),
    KEY `idx-book-owner_id` (`owner_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '책 정보';


CREATE TABLE `t_book_like`
(
    `seq`           BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `id`            VARCHAR(64)         NOT NULL               COMMENT '좋아요 정보의 id',
    `identity_id`   VARCHAR(64)         NOT NULL               COMMENT 'book_id로 id를 가진 책에 좋아요 누른 사람 id',
    `book_id`       VARCHAR(64)         NOT NULL               COMMENT 'identity_id로 id를 가진 사람이 누른 책의 id',
    `is_liked`      VARCHAR(1)          NOT NULL  DEFAULT 't'  COMMENT '다시 좋아요가 눌러지면 "f", 아니면 "t". (soft delete)',
    `createdAt`     TIMESTAMP           NOT NULL  DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP           NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`seq`),
    UNIQUE KEY `uix-book-id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '책을 좋아요 누른 사람의 정보';


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
  DEFAULT CHARSET = utf8mb4 COMMENT '유저 정보';
