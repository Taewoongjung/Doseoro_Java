package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.error.exception.BusinessException;
import com.myproject.doseoro.global.error.exception.ErrorCode;
import com.myproject.doseoro.global.util.Logging;
import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.vo.BookHitVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HitLikeCommandHandler implements ICommandHandler<BookHitVO, BookHitVO>{

    private final BookMybatisService repository;

    @Logging
    @Override
    public BookHitVO handle(BookHitVO vo) {

        String uuid = UUID.randomUUID().toString();
        vo.imbueId(uuid);

        // 해당 객체(책)에 처음 좋아요 남기니까 새로운 row 생성
        repository.hitLike(vo);
        return vo;
    }
}
