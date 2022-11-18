package com.myproject.doseoro.application.book.readmodel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
import com.myproject.doseoro.book.BookHitVOFixture;
import com.myproject.doseoro.book.BookVOFixture;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllBooksByBookIdQueryTest {

    @InjectMocks
    GetAllInformationOfTheBookByBookIdQuery sut;

    @Mock
    private BookRepository bookMybatisService;
    @Mock
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("해당 책의 id에 해당 하는 책의 모든 정보를 불러온다.")
    void test() {

        BookVO registeredBook1 = BookVOFixture.firstBookVO();
        BookHitVO bookLikedList = BookHitVOFixture.bookHitVO;

        List<BookHitVO> countLikedInTheBook = new ArrayList<>();
        countLikedInTheBook.add(bookLikedList);

        when(bookMybatisService.findBookByBookId("777")).thenReturn(registeredBook1);
        when(accessUserSessionManager.extractUser()).thenReturn("12312315256787");
        when(bookMybatisService.countLike("777")).thenReturn(countLikedInTheBook);

        when(bookMybatisService.isBookLiked(
            new FindIfBookIsLikedVo("12312315256787", "777"))
        ).thenReturn("true");

        GetAllInformationOfTheBookByBookIdDtoResult actual = sut.query(
            new GetAllInformationOfTheBookByBookIdDto("777"));

        assertThat(actual).isNotNull();
        assertThat(actual.getBook().getId()).isEqualTo("777");
        assertThat(actual.getBook().getTitle()).isEqualTo("정말 재미 있는 책");
        assertThat(actual.getBook().getOwnerId()).isEqualTo("12312315256787");
        assertThat(actual.getBook().getUserNickName()).isEqualTo("홍도");

        assertThat(actual.getCountLikedInTheBook().size()).isEqualTo(1);
        assertThat(actual.getIsLikeExisted()).isEqualTo("true");
    }
}