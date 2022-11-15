package com.myproject.doseoro.application.book.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.BookRepository;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HitLikeCommandHandler implements CommandHandler<BookHitVO, BookHitVO> {

    private final BookRepository repository;

    @Logging
    @Override
    public BookHitVO handle(BookHitVO vo) {

        vo.imbueId();
        repository.hitLike(vo);

        return vo;
    }
}
