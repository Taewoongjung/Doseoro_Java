package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.contract.abstraction.CommandHandler;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import com.myproject.doseoro.domain.book.repository.BookRepository;
import com.myproject.doseoro.domain.identity.repository.IdentityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
        String IfThereChunkAtTheLastOfLetter = checkLastLetterOfOwnerEmail(ownerEmail);
        AccessUserVO user = identityRepository.findUserByEmail(IfThereChunkAtTheLastOfLetter);
        return user.getUserId();
    }

    private String checkLastLetterOfOwnerEmail(String ownerEmail) {
        boolean flag = ownerEmail.endsWith("/");
        if (flag) {
            return removeLastLetterAfterChecking(ownerEmail);
        }
        return ownerEmail;
    }

    private String removeLastLetterAfterChecking(String ownerEmail) {
        return StringUtils.chop(ownerEmail);
    }
}
