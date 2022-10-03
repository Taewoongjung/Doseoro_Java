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