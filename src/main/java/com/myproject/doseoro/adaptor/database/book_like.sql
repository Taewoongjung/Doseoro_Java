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