package com.myproject.doseoro.api.identity.controllers;

import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final CreateUserIdentityCommandHandler createUserIdentityCommandHandler;

    @RequestMapping(value = "/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "home";
    }

    @RequestMapping(value = "/idx")
    public String index(Map<String, Object> model) {
        return "index";
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

    @PostMapping(value = "/auth/signup")
    public String userSignup(SignUpRequest dto, Model model) throws Exception {
        System.out.println("comSignup called");
        System.out.println(dto);

        boolean identity = createUserIdentityCommandHandler.signUp(dto);
        if (!identity) {
            System.out.println("중복된 이메일");
            model.addAttribute("msg", "중복된 이메일 입니다.");
            model.addAttribute("url", "/signup");
            return "error";
        }
        System.out.println("signup end point = "+identity);
        return "redirect:/";
    }

    @RequestMapping(value = "/find")
    public void findAllByEmail() throws Exception {
        createUserIdentityCommandHandler.findThis();
        createUserIdentityCommandHandler.emailExist();
    }
}
