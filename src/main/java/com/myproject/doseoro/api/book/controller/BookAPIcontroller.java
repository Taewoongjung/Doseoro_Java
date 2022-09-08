package com.myproject.doseoro.api.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value = "/book")
public class BookAPIcontroller {

    @PostMapping(value = "/register")
    public String registerBook() {
        return "a";
    }
}
