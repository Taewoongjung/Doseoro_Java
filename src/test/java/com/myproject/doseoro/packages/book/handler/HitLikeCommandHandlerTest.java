package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.dao.DoseoroDao;
import com.myproject.doseoro.packages.book.vo.BookHitVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
            "2525",
            "f"
        );

        // when
        sut.handle(vo);
        List<BookHitVO> actual = bookRepository.isLikedByUserId(vo.getUserId(), vo.getBookId());

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.get(0).getUserId()).isEqualTo("1212");
        assertThat(actual.get(0).getBookId()).isEqualTo("2525");
    }

//    @Test
//    @DisplayName("유저가 좋아요를 누른 책에 다시 누르면 좋아요 취소 된다.")
//    @Transactional
//    public void duplicateClicked() {
//        // given
//        BookMybatisService bookRepository = new BookMybatisService(dao);
//        HitLikeCommandHandler hitLikeCommandHandler = new HitLikeCommandHandler(bookRepository);
//        HitReLikeCommandHandler hitReLikeCommandHandler = new HitReLikeCommandHandler(bookRepository);
//
//        BookHitVO vo1 = new BookHitVO(
//            "11111212",
//            "1212",
//            "2525",
//            "t"
//        );
//
//        // when
//        BookHitVO voo = hitLikeCommandHandler.handle(vo1);
//        System.out.println("after @@@ = " + voo);
//
//        BookHitVO voo1 = hitReLikeCommandHandler.handle(vo1);
//        System.out.println("#@@!@!@ = " + voo1);
//
//        BookHitVO vo2 = new BookHitVO(
//                "11111212",
//                "1212",
//                "2525",
//                "t"
//        );
//
//        BookHitVO vooo = hitReLikeCommandHandler.handle(vo2);
//        System.out.println("#@@!@!@ = " + vooo);
//
//        // then
//        assertThat(vooo.getIsLiked()).isEqualTo("t");
//    }
}
