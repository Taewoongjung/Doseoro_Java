package com.myproject.doseoro.application.book.readmodel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.book.vo.FindIfBookIsLikedVo;
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
class GetAllInformationOfTheBookByBookIdQueryTest {

    @InjectMocks
    GetAllInformationOfTheBookByBookIdQuery sut;

    @Mock
    private BookRepository bookMybatisService;
    @Mock
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("판매 책의 모든 정보를 조회한다.")
    void test1() {
        BookVO book = BookVOFixture.firstBookVO();

        when(bookMybatisService.findBookByBookId(book.getId())).thenReturn(book);
        when(accessUserSessionManager.extractUser()).thenReturn("111");
        when(bookMybatisService.isBookLiked(
            new FindIfBookIsLikedVo("111", book.getId()))).thenReturn("111");

        GetAllInformationOfTheBookByBookIdDtoResult actual = sut.query(
            new GetAllInformationOfTheBookByBookIdDto(book.getId()));

        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        assertThat(actual).isNotNull();
        assertThat(actual.getBook().getId()).isEqualTo("777");
        assertThat(actual.getBook().getPostMessage()).isEqualTo("책팝니다 ~");
        assertThat(actual.getBook().getTitle()).isEqualTo("정말 재미 있는 책");
        assertThat(actual.getBook().getPrice()).isEqualTo("100000");
        assertThat(actual.getBook().getAuthor()).isEqualTo("난 천재");
        assertThat(actual.getBook().getPublisher()).isEqualTo("출판사");
        assertThat(actual.getBook().getCategory()).isEqualTo(checkCategory);
        assertThat(actual.getBook().getState()).isEqualTo(checkState);
        assertThat(actual.getBook().getImages()).isEqualTo(images);
        assertThat(actual.getBook().getTradeMethod()).isEqualTo("직거래");
        assertThat(actual.getBook().getSold()).isEqualTo("0");
        assertThat(actual.getBook().getAbout()).isEqualTo("재미있는 책 팜");
        assertThat(actual.getBook().getHits()).isEqualTo(77);
        assertThat(actual.getBook().getOwnerId()).isEqualTo("12312315256787");

    }

    @Test
    @DisplayName("무료나눔 책의 모든 정보를 조회한다.")
    void test2() {
        BookVO book = BookVOFixture.firstBookVODonation();

        when(bookMybatisService.findBookByBookId(book.getId())).thenReturn(book);
        when(accessUserSessionManager.extractUser()).thenReturn("111");
        when(bookMybatisService.isBookLiked(
            new FindIfBookIsLikedVo("111", book.getId()))).thenReturn("111");

        GetAllInformationOfTheBookByBookIdDtoResult actual = sut.query(
            new GetAllInformationOfTheBookByBookIdDto(book.getId()));

        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        List<String> checkState = new ArrayList<>();
        checkState.add("깨끗");
        checkState.add("거의 새책");

        List<String> images = new ArrayList<>();
        images.add("imgs1e51ca13-e32e-4db8-a308-bf4ccdd2c15f");
        images.add("imgs0c1d16f2-a946-468f-8bcc-ffdc8f57b2fe");

        assertThat(actual).isNotNull();
        assertThat(actual.getBook().getId()).isEqualTo("777");
        assertThat(actual.getBook().getPostMessage()).isEqualTo("책팝니다 ~");
        assertThat(actual.getBook().getTitle()).isEqualTo("정말 재미 있는 책");
        assertThat(actual.getBook().getPrice()).isEqualTo(null);
        assertThat(actual.getBook().getAuthor()).isEqualTo("난 천재");
        assertThat(actual.getBook().getPublisher()).isEqualTo("출판사");
        assertThat(actual.getBook().getCategory()).isEqualTo(checkCategory);
        assertThat(actual.getBook().getState()).isEqualTo(checkState);
        assertThat(actual.getBook().getImages()).isEqualTo(images);
        assertThat(actual.getBook().getTradeMethod()).isEqualTo("직거래");
        assertThat(actual.getBook().getSold()).isEqualTo("0");
        assertThat(actual.getBook().getAbout()).isEqualTo("재미있는 책 팜");
        assertThat(actual.getBook().getHits()).isEqualTo(77);
        assertThat(actual.getBook().getOwnerId()).isEqualTo("12312315256787");
        assertThat(actual.getBook().getDonation()).isEqualTo("1");
        assertThat(actual.getBook().getIsBuying()).isEqualTo("0");

    }
}