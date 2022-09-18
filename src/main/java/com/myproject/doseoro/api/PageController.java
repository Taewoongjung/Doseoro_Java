package com.myproject.doseoro.api;

import com.myproject.doseoro.packages.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;

    @RequestMapping(value = "/")
    public String home(Model model) throws IOException {
        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        model.addAttribute("books", list);
        System.out.println("home = " + list);
        System.out.println("home called");
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
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
