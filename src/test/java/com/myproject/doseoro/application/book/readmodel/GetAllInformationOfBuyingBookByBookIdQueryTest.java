package com.myproject.doseoro.application.book.readmodel;

import static com.myproject.doseoro.identity.IdentityMyPageVOFixture.identityMyPageVO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.book.BookVOFixture;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllInformationOfBuyingBookByBookIdQueryTest {

    @InjectMocks
    private GetAllInformationOfBuyingBookByBookIdQuery sut;

    @Mock
    private BookRepository bookMybatisService;
    @Mock
    private IdentityRepository repository;

    @Test
    @DisplayName("책 구매 요청(삽니다)의 정보를 조회한다.")
    void test() {
        BookVO book = BookVOFixture.firstBookVOForBuying();

        List<String> checkCategory = new ArrayList<>();
        checkCategory.add("SF");
        checkCategory.add("만화");

        when(bookMybatisService.findBuyingBookByBookId(book.getId())).thenReturn(book);
        when(repository.findUserById(book.getOwnerId())).thenReturn(identityMyPageVO);

        GetAllInformationOfBuyingBookByBookIdDtoResult actual = sut.query(
            new GetAllInformationOfBuyingBookByBookIdDto(book.getId()));

        assertThat(actual).isNotNull();
        assertThat(actual.getBook().getId()).isEqualTo("777");
        assertThat(actual.getBook().getPostMessage()).isEqualTo("이 책 갖고 계신분 ~");
        assertThat(actual.getBook().getTitle()).isEqualTo("정말 재미 있는 책");
        assertThat(actual.getBook().getAuthor()).isEqualTo("난 천재");
        assertThat(actual.getBook().getPublisher()).isEqualTo("출판사");
        assertThat(actual.getBook().getCategory()).isEqualTo(checkCategory);
        assertThat(actual.getBook().getTradeMethod()).isEqualTo("직거래");
        assertThat(actual.getBook().getSold()).isEqualTo("0");
        assertThat(actual.getBook().getAbout()).isEqualTo("이 책 구매 원해요");
        assertThat(actual.getBook().getOwnerId()).isEqualTo("12312315256787");

        assertThat(actual.getUser().getId()).isEqualTo("12312315256787");
        assertThat(actual.getUser().getEmail()).isEqualTo("a@a.com");
        assertThat(actual.getUser().getName()).isEqualTo("홍길동");
        assertThat(actual.getUser().getNickName()).isEqualTo("길도이");
        assertThat(actual.getUser().getPhone()).isEqualTo("010-2111-7777");
        assertThat(actual.getUser().getLocation()).isEqualTo("경기도 용인시 보정동");
        assertThat(actual.getUser().getDong()).isEqualTo("보정동");
        assertThat(actual.getUser().getSi()).isEqualTo("용인시");
        assertThat(actual.getUser().getDou()).isEqualTo("경기도");
        assertThat(actual.getUser().getProvider()).isEqualTo("kakao");
        assertThat(actual.getUser().getSnsId()).isEqualTo("12321-11");
        assertThat(actual.getUser().getUpdatedAt()).isEqualTo("11-11-11");

    }
}