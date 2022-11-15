package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterDonationBookCommandHandler implements
    CommandHandler<RegisterBookVO, RegisterBookVO> {

    private final BookRepository repository;
    private final IdentityRepository identityRepository;

    @Logging
    @Override
    public RegisterBookVO handle(RegisterBookVO vo) {

        String ownerId = getOwnerId(vo.getOwnerEmail());

        vo.imbueId();
        vo.imbueOwnerId(ownerId);

        repository.registerDonationBook(vo);
        return vo;
    }

    private String getOwnerId(String ownerEmail) {

        AccessUserVO user = identityRepository.findUserByEmail(ownerEmail);
        return user.getUserId();
    }
}
