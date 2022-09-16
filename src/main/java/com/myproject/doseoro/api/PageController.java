package com.myproject.doseoro.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PageController {

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("home called");
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
