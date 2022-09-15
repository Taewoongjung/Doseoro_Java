package com.myproject.doseoro.api;

import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final BookMybatisService service;

    @RequestMapping(value = "/")
    public String home(Model model) {
        List<HomeDisplayedBookVO> list = service.findHomeDisplayedBooks();

        System.out.println(list);
        model.addAttribute("books", list);

        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(Map<String, Object> model) {
        System.out.println("login called");
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        System.out.println("signup called");
        return "signup";
    }

    @RequestMapping(value = "/saleBoard")
    public String sale() {
        System.out.println("saleBoard called");
        return "saleBoard";
    }

    @RequestMapping(value = "/registerBook")
    public String registerBook() {
        System.out.println("registerBook called");
        return "registerBook";
    }
}
