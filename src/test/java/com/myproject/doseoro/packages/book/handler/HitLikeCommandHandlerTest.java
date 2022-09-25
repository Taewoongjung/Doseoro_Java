package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.packages.book.vo.BookHitVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HitLikeCommandHandlerTest {

    @Autowired
    private DoseoroDao dao;

    @Test
    @DisplayName("유저는 좋아요를 누른다.")
    @Transactional
    public void CommandHandlerTest() {
        // given
        BookMybatisService bookRepository = new BookMybatisService(dao);
        HitLikeCommandHandler sut = new HitLikeCommandHandler(bookRepository);

        BookHitVO vo = new BookHitVO(
            "11111212",
            "1212",
            "2525"
        );

        // when
        sut.handle(vo);
        List<BookHitVO> actual = bookRepository.isLikedByUserId(vo.getUserId(), vo.getBookId());

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.get(0).getUserId()).isEqualTo("1212");
        assertThat(actual.get(0).getBookId()).isEqualTo("2525");
    }

    @Test
    @DisplayName("유저가 좋아요를 누른 책에 다시 누르면 에러가 발생한다.")
    @Transactional
    public void duplicateClicked() {
        // given
        BookMybatisService bookRepository = new BookMybatisService(dao);
        HitLikeCommandHandler sut = new HitLikeCommandHandler(bookRepository);

        BookHitVO vo = new BookHitVO(
            "11111212",
            "1212",
            "2525"
        );

        // when
        bookRepository.hitLike(vo);

        // then
        assertThrows(BusinessException.class, () -> sut.handle(vo));
    }
}
