package com.myproject.doseoro.application.book.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDtoResult;
import com.myproject.doseoro.application.contract.abstraction.CommandQuery;
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
    private final AccessUserSessionManager accessUserSessionManager;

    @Logging
    @Override
    public GetAllInformationOfBuyingBookByBookIdDtoResult query(
        GetAllInformationOfBuyingBookByBookIdDto book) {
        return null;
    }
}
