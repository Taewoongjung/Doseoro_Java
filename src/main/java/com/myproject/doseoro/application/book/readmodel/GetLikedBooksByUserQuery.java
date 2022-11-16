package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetLikedBooksByUserQuery implements CommandQuery<Void, GetLikedBooksByUserDtoResult> {

    private final BookRepository bookMybatisRepository;
    private final AccessUserSessionManager accessUserSessionManager;

    @Override
    public GetLikedBooksByUserDtoResult query(Void unused) {
        String userId = getUserIdFromSession();

        if (userId == null) {
            return null;
        }

        List<AllLikedBookVO> foundAllBooks = getAllLikedBook(userId);
        List<String> listOfBookId = makeListOfBookId(foundAllBooks);
        List<BookVO> bookList = makeListOfBooks(listOfBookId);

        return new GetLikedBooksByUserDtoResult(bookList);
    }

    private String getUserIdFromSession() {
        return accessUserSessionManager.extractUser();
    }

    private List<AllLikedBookVO> getAllLikedBook(String userId) {
        return bookMybatisRepository.allLikedBook(userId);
    }

    private List<String> makeListOfBookId(List<AllLikedBookVO> list) {
        return list.stream()
            .map(book -> book.getBookId())
            .collect(Collectors.toList());
    }

    private List<BookVO> makeListOfBooks(List<String> listOfBookId) {
        List<BookVO> books = new ArrayList<>();
        listOfBookId.forEach(bookId -> books.add(bookMybatisRepository.findBookByBookId(bookId)));
        return books;
    }
}
