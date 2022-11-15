package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.CommandQuery;
import com.myproject.doseoro.application.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.application.book.vo.AllLikedBookVO;
import com.myproject.doseoro.application.book.vo.BookVO;
import java.util.ArrayList;
import java.util.List;
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

        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < listOfBookId.size(); i++) {
            books.add(bookMybatisRepository.findBookByBookId(listOfBookId.get(i)));
        }

        return new GetLikedBooksByUserDtoResult(books);
    }

    private String getUserIdFromSession() {
        return accessUserSessionManager.extractUser();
    }

    private List<AllLikedBookVO> getAllLikedBook(String userId) {
        return bookMybatisRepository.allLikedBook(userId);
    }

    private List<String> makeListOfBookId(List<AllLikedBookVO> list) {
        return list.stream().map(AllLikedBookVO::getBookId).toList();
    }

    private List<BookVO> makeListOfBooks(List<String> listOfBookId) {
        List<BookVO> books = new ArrayList<>();
        for (String bookId : listOfBookId) {
            books.add(bookMybatisRepository.findBookByBookId(listOfBookId.get(bookId)));
        }
    }
}
