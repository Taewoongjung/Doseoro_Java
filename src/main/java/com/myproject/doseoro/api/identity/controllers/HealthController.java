package com.myproject.doseoro.api.identity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HealthController {

    @RequestMapping(value = "/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "home";
    }

    @RequestMapping(value = "/idx")
    public String index(Map<String, Object> model) {
        return "index";
    }
}
