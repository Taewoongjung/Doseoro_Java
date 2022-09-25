package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.global.error.exception.ErrorCode;
import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.vo.BookHitVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HitLikeCommandHandler implements ICommandHandler<BookHitVO, Void>{

    private final BookMybatisService repository;

    @Override
    public Void handle(BookHitVO vo) {
        System.out.println("!! "+repository.isLikedByUserId(vo.getUserId(), vo.getBookId()).isEmpty());

        if (!repository.isLikedByUserId(vo.getUserId(), vo.getBookId()).isEmpty()) {
            throw new BusinessException(ErrorCode.ALREADY_LIKED);
        }

        String uuid = UUID.randomUUID().toString();
        vo.imbueId(uuid);

        repository.hitLike(vo);
        return null;
    }
}
