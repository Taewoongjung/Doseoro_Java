package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.domain.book.abstraction.BookRepository;
import com.myproject.doseoro.domain.book.vo.BookHitVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HitLikeCommandHandler implements CommandHandler<BookHitVO, BookHitVO> {

    private final BookRepository repository;

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
