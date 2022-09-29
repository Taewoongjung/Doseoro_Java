package com.myproject.doseoro.adaptor.api.book.controller;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.handler.*;
import com.myproject.doseoro.domain.book.dto.BookDetailDto;
import com.myproject.doseoro.domain.book.dto.BookDetailDtoResult;
import com.myproject.doseoro.domain.book.vo.RegisterBookVO;
import com.myproject.doseoro.domain.book.vo.BookVO;
import com.myproject.doseoro.domain.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.domain.book.vo.BookHitVO;
import com.myproject.doseoro.domain.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.adaptor.infra.mybatis.identity.IdentityMybatisRepository;
import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class BookAPIcontroller {

    private final RegisterBookCommandHandler registerBookCommandHandler;
    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final HitLikeCommandHandler hitLikeCommandHandler;
    private final HitReLikeCommandHandler hitReLikeCommandHandler;
    private final BookDetailPageQuery bookDetailPageQuery;

    @Logging
    @PostMapping(value = "/book/register")
    public String registerBook(@RequestParam("img") List<MultipartFile> multipartFile, RegisterBookVO vo) {

        try {
            vo.multipleImageFileHandle(multipartFile, vo);
            registerBookCommandHandler.handle(vo);
        } catch (Exception e) { // BussinessException 로직 추가하기
            e.printStackTrace();
        }

        return "redirect:/saleBoard";
    }

    @Logging
    @GetMapping(value = "/book/find/booksForHome")
    public List<HomeDisplayedBookVO> findBooks() {

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        return list;
    }

    @Logging
    @GetMapping(value = "/{bookId}")
    public ModelAndView bookDetailPage(ModelAndView model, @PathVariable String bookId) {

        try {
            BookDetailDtoResult result = bookDetailPageQuery.query(new BookDetailDto(bookId));

            model.setViewName("saleDetail");
            model.addObject("user", result.getUser());
            model.addObject("title", result.getBook().getPostMessage());
            model.addObject("book", result.getBook());
            model.addObject("countLike", result.getCountLikedInTheBook().size());
            if(result.getIsLikeExisted() != null) model.addObject("isLiked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Logging
    @PostMapping(value = "/like")
    public String hitLike(BookHitVO vo) {

        BookHitVO alreadyLiked = hitReLikeCommandHandler.handle(vo);
        if(alreadyLiked.getId() != null || vo.getId() != null) { return "redirect:/" + vo.getBookId(); }

        // hitLikeCommandHandler 핸들러에서 id 값을 넣어 주니까
        // id 값이 있으면(null 이 아니면) 다시 row 를 생성할 필요가 없으니 null 리턴

        hitLikeCommandHandler.handle(vo);

        return "redirect:/"+vo.getBookId();
    }
}
