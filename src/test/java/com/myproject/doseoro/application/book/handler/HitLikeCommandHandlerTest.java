package com.myproject.doseoro.application.book.handler;

import static org.assertj.core.api.Assertions.assertThat;

import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.book.BookHitVOFixture;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class HitLikeCommandHandlerTest {

    @Autowired
    private BookMybatisRepository bookRepository;

    @Test
    @DisplayName("유저는 좋아요를 누른다.")
    @Transactional
    public void CommandHandlerTest() {
        // given
        HitLikeCommandHandler sut = new HitLikeCommandHandler(bookRepository);

        BookHitVO vo = BookHitVOFixture.bookHitVO;

        // when
        sut.handle(vo);
        List<BookHitVO> actual = bookRepository.isLikedByUserIdAndBookId(vo.getUserId(),
            vo.getBookId());

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
        HitReLikeCommandHandler sut = new HitReLikeCommandHandler(bookRepository);

        BookHitVO likeObject = BookHitVOFixture.bookHitVO;

        // when
        bookRepository.hitLike(likeObject);
        sut.handle(likeObject);
        List<BookHitVO> actual = bookRepository.isLikedByUserIdAndBookId(likeObject.getUserId(),
            likeObject.getBookId());

        // then
        assertThat(actual.get(0).getIsLiked()).isEqualTo("f");
    }
}
