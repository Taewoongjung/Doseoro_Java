package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.global.util.Logging;
import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.vo.BookHitVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HitReLikeCommandHandler implements ICommandHandler<BookHitVO, BookHitVO> {

    private final BookMybatisService repository;

    @Logging
    @Override
    public BookHitVO handle(BookHitVO vo) {
        List<BookHitVO> found = repository.isLikedByUserId(vo.getUserId(), vo.getBookId());
        if (found.size() == 0) return vo;
        // 좋아요 요청 들어오면 유저 이력 유무 검사.
        // 해당 객체에 좋아요 누른 이력이 없었으면 객체 그대로 리턴

        if (!found.get(0).getId().isEmpty()) { // 유저의 좋아요 이력이 있을 때

            if (found.get(0).getIsLiked().equals("f")) {
                // 좋아요 안 눌러져 있을때
                repository.hitReLikeWhenUnLiked(found.get(0).getUserId(), found.get(0).getBookId(), found.get(0).getIsLiked());

            } else {
                // 좋아요 눌러져 있을때
                repository.hitReLikeWhenLiked(found.get(0).getUserId(), found.get(0).getBookId(), found.get(0).getIsLiked());
            }
            return found.get(0);
        }
        return found.get(0);
    }
}