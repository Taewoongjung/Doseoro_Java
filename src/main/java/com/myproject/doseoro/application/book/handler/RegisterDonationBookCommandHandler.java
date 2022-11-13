package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import com.myproject.doseoro.application.identity.vo.AccessUserVO;
import java.util.UUID;
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
        System.out.println(vo);
        System.out.println(StringUtils.chop(vo.getOwnerEmail()));
        final String uuid = UUID.randomUUID().toString();

        AccessUserVO user = identityRepository.findUserByEmail(
            StringUtils.chop(vo.getOwnerEmail()));
        System.out.println("user = " + user);
        String idToBeSetInDTO = user.getUserId();

        vo.imbueId(uuid);
        vo.imbueOwnerId(idToBeSetInDTO);

        repository.registerDonationBook(vo);
        return vo;
    }
}
