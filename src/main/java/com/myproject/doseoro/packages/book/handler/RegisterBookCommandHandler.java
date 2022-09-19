package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.identity.vo.AccessUserVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
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

        AccessUserVO user = identityRepository.findByEmail(dto.getOwnerEmail());
        String idToBeSetInDTO = user.getUserId();

        dto.setOwnerId(idToBeSetInDTO);
        dto.setId(uuid);

        repository.registerBook(dto);
        return dto;
    }
}
