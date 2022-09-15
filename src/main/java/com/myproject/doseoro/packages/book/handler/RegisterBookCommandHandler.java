package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.identity.vo.AccessUser;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.infra.session.AccessUserSessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterBookCommandHandler implements ICommandHandler<RegisterBookDTO, RegisterBookDTO> {

    private final BookMybatisService repository;
    private final IdentityMybatisService identityRepository;

    @Override
    public RegisterBookDTO handle(RegisterBookDTO dto) {
        final String uuid = UUID.randomUUID().toString();
        System.out.println("in handler = " + dto);

//        StringUtils.removeEnd(sessionScope.email)

        AccessUser user = identityRepository.findByEmail(dto.getOwnerEmail());
        System.out.println("@@ = "+ user);
        String idToBeSetInDTO = user.getUserId();

        dto.setOwnerId(idToBeSetInDTO);
        dto.setId(uuid);

        System.out.println("After all = "+ dto);

        repository.registerBook(dto);
        return dto;
    }
}
