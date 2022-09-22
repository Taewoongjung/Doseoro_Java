package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.vo.RegisterBookVO;
import com.myproject.doseoro.packages.identity.vo.AccessUserVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterBookCommandHandler implements ICommandHandler<RegisterBookVO, RegisterBookVO> {

    private final BookMybatisService repository;
    private final IdentityMybatisService identityRepository;

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
