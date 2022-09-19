package com.myproject.doseoro.api.book.controller;

import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.packages.book.handler.RegisterBookCommandHandler;
import com.myproject.doseoro.packages.book.vo.BookVO;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookAPIcontroller {

    private final RegisterBookCommandHandler registerBookCommandHandler;
    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final BookMybatisService bookMybatisService;
    private final IdentityMybatisService repository;


    @PostMapping(value = "/book/register")
    public String registerBook(@RequestParam("img") List<MultipartFile> multipartFile, RegisterBookDTO dto) {
        log.info("[API Called] Book Register");
        try {
            dto.multipleImageFileHandle(multipartFile, dto);
            RegisterBookDTO resultDto = registerBookCommandHandler.handle(dto);
            System.out.println("완료 = " + resultDto);
            log.info("[LOGIC] Book Registered = " + dto);

        } catch (Exception e) { // BussinessException 로직 추가하기
            e.printStackTrace();
        }

        return "redirect:/saleBoard";
    }

    @GetMapping(value = "/book/find/booksForHome")
    public List<HomeDisplayedBookVO> findBooks() {
        log.info("[API Called] Display List For Home");

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        return list;
    }

    @GetMapping(value = "/{bookId}")
    public ModelAndView bookDetailPage(ModelAndView model, @PathVariable String bookId) {
        log.info("[API Called] Book Detail");
        try {

            BookVO book = bookMybatisService.findBookByBookId(bookId);
            System.out.println(book);
            IdentityMyPageVO user = repository.findUserById(book.getOwnerId());
            System.out.println(user.getNickName());
            model.setViewName("saleDetail");
            model.addObject("nickName", user.getNickName());
            model.addObject("title", book.getPostMessage());
            model.addObject("book", book);
        } catch (Exception e) {
            log.warn("[API Called] do not matter, it is book detail");
            e.printStackTrace();
        }
        return model;
    }
}
