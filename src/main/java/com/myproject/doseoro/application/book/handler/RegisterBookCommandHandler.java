package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.domain.book.abstraction.BookRepository;
import com.myproject.doseoro.domain.book.vo.RegisterBookVO;
import com.myproject.doseoro.domain.identity.abstraction.IdentityRepository;
import com.myproject.doseoro.domain.identity.vo.AccessUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterBookCommandHandler implements CommandHandler<RegisterBookVO, RegisterBookVO> {

    private final BookRepository repository;
    private final IdentityRepository identityRepository;

    @Logging
    @Override
    public RegisterBookVO handle(RegisterBookVO vo) {
        final String uuid = UUID.randomUUID().toString();

        AccessUserVO user = identityRepository.findUserByEmail(vo.getOwnerEmail());
        String idToBeSetInDTO = user.getUserId();

        vo.imbueId(uuid);
        vo.imbueOwnerId(idToBeSetInDTO);

        repository.registerBook(vo);
        return vo;
    }
}
