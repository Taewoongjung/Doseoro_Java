package com.myproject.doseoro.api.book.controller;

import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import com.myproject.doseoro.packages.book.handler.RegisterBookCommandHandler;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller()
@RequiredArgsConstructor
public class BookAPIcontroller {

    private final RegisterBookCommandHandler registerBookCommandHandler;

    private final BookMybatisService service;

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
    public void findBooks() {
        List<HomeDisplayedBookVO> list = service.findHomeDisplayedBooks();

        System.out.println("@@@ = " + list);
    }
}
