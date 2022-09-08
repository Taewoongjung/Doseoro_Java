package com.myproject.doseoro.api.identity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
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
        System.out.println("sale called");
        return "saleBoard";
    }
}
