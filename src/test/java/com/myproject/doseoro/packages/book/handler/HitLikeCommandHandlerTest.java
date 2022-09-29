package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.adaptor.infra.dao.DoseoroDao;
import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.application.book.handler.HitLikeCommandHandler;
import com.myproject.doseoro.application.book.handler.HitReLikeCommandHandler;
import com.myproject.doseoro.domain.book.vo.BookHitVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HitLikeCommandHandlerTest {

    @Autowired
    private DoseoroDao dao;

    @Test
    @DisplayName("유저는 좋아요를 누른다.")
    @Transactional
    public void CommandHandlerTest() {
        // given
        BookMybatisRepository bookRepository = new BookMybatisRepository(dao);
        HitLikeCommandHandler sut = new HitLikeCommandHandler(bookRepository);

        BookHitVO vo = new BookHitVO(
            "11111212",
            "1212",
            "2525",
            "t"
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
    @DisplayName("유저가 좋아요를 누른 책에 다시 누르면 좋아요 취소 된다.")
    @Transactional
    public void duplicateClicked() {
        // given
        BookMybatisRepository repository = new BookMybatisRepository(dao);
        HitReLikeCommandHandler sut = new HitReLikeCommandHandler(repository);

        BookHitVO likeObject = new BookHitVO(
                "11111212",
                "1212",
                "2525",
                "t"
        );

        // when
        repository.hitLike(likeObject);
        sut.handle(likeObject);
        List<BookHitVO> actual = repository.isLikedByUserId(likeObject.getUserId(), likeObject.getBookId());

        // then
        assertThat(actual.get(0).getIsLiked()).isEqualTo("f");
    }
}
