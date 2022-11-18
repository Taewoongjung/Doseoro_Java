package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.vo.BookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllInformationOfBuyingBookByBookIdQuery implements
    CommandQuery<GetAllInformationOfBuyingBookByBookIdDto, GetAllInformationOfBuyingBookByBookIdDtoResult> {

    private final BookRepository bookMybatisService;
    private final IdentityRepository repository;

    @Logging
    @Override
    public GetAllInformationOfBuyingBookByBookIdDtoResult query(
        GetAllInformationOfBuyingBookByBookIdDto book) {

        BookVO foundBook = findBookByBookId(book.getBookId());
        IdentityMyPageVO user = findUserById(foundBook.getOwnerId());

        return new GetAllInformationOfBuyingBookByBookIdDtoResult(
            foundBook, user
        );
    }

    private BookVO findBookByBookId(String bookId) {
        return bookMybatisService.findBuyingBookByBookId(bookId);
    }

    private IdentityMyPageVO findUserById(String userId) {
        return repository.findUserById(userId);
    }

}
