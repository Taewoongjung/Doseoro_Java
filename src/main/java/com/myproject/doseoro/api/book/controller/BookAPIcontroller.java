package com.myproject.doseoro.api.book.controller;

import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.packages.book.handler.RegisterBookCommandHandler;
import com.myproject.doseoro.packages.book.vo.BookVO;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller()
@RequiredArgsConstructor
public class BookAPIcontroller {

    private final RegisterBookCommandHandler registerBookCommandHandler;
    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final BookMybatisService bookMybatisService;

    @PostMapping(value = "/book/register")
    public String registerBook(@RequestParam("img") List<MultipartFile> multipartFile, RegisterBookDTO dto) {
        System.out.println("try book register");
        System.out.println("in API = " + dto);
        try {
            dto.multipleImageFileHandle(multipartFile, dto);
            RegisterBookDTO resultDto = registerBookCommandHandler.handle(dto);
            System.out.println("완료 = " + resultDto);

        } catch (Exception e) { // BussinessException 로직 추가하기
            e.printStackTrace();
        }

        return "redirect:/saleBoard";
    }

    @GetMapping(value = "/book/find/booksForHome")
    public List<HomeDisplayedBookVO> findBooks() {
        System.out.println("display list called");

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        return list;
    }

    @GetMapping(value = "/book/{bookId}")
    public String bookDetailPage(Model model, @PathVariable String bookId) {
        System.out.println("book detail called");

        BookVO book = bookMybatisService.findBookByBookId(bookId);
        System.out.println(book);
        model.addAttribute("title", book.getPostMessage());
        model.addAttribute("book", book);
        return "saleDetail";
    }
}
