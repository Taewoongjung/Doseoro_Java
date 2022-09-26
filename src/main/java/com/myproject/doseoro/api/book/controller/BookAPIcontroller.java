package com.myproject.doseoro.api.book.controller;

import com.myproject.doseoro.packages.book.handler.HitLikeCommandHandler;
import com.myproject.doseoro.packages.book.handler.HitReLikeCommandHandler;
import com.myproject.doseoro.packages.book.vo.RegisterBookVO;
import com.myproject.doseoro.packages.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.packages.book.handler.RegisterBookCommandHandler;
import com.myproject.doseoro.packages.book.vo.BookVO;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.book.vo.BookHitVO;
import com.myproject.doseoro.packages.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final BookMybatisService bookMybatisService;
    private final IdentityMybatisService repository;

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

    @GetMapping(value = "/book/find/booksForHome")
    public List<HomeDisplayedBookVO> findBooks() {

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        return list;
    }

    @GetMapping(value = "/{bookId}")
    public ModelAndView bookDetailPage(ModelAndView model, @PathVariable String bookId) {

        try {
            BookVO book = bookMybatisService.findBookByBookId(bookId);
            System.out.println(book);
            IdentityMyPageVO user = repository.findUserById(book.getOwnerId());
            System.out.println(user.getNickName());
            model.setViewName("saleDetail");
            model.addObject("user", user);
            model.addObject("title", book.getPostMessage());
            model.addObject("book", book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @PostMapping(value = "/like")
    public String hitLike(Model model, BookHitVO vo) {

        BookHitVO alreadyLiked = hitReLikeCommandHandler.handle(vo);
        if(alreadyLiked.getId() != null) { return "redirect:/" + vo.getBookId(); }

        hitLikeCommandHandler.handle(vo);
//        model.addAttribute("likeCount", likeCountResult);

        return "redirect:/"+vo.getBookId();
    }
}
