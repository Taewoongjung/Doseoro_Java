package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.domain.book.vo.AllLikedBookVO;
import com.myproject.doseoro.domain.book.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLikedBooksByUserQuery implements CommandQuery<Void, GetLikedBooksByUserDtoResult> {

    private final BookMybatisRepository bookMybatisRepository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Override
    public GetLikedBooksByUserDtoResult query(Void unused) {
        String userId = accessUserSessionManager.extractUser();

        List<AllLikedBookVO> foundAllBooks = bookMybatisRepository.allLikedBook(userId);
        List<String> listOfBookId = foundAllBooks.stream()
                .map(AllLikedBookVO::getBookId).toList();

        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < listOfBookId.size(); i++) {
            books.add(bookMybatisRepository.findBookByBookId(listOfBookId.get(i)));
        }

        return new GetLikedBooksByUserDtoResult(books);
    }
}
