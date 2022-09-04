package com.myproject.doseoro.api.identity.controllers;

import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class APIcontroller {

    private final CreateUserIdentityCommandHandler createUserIdentityCommandHandler;

    @PostMapping(value = "/auth/signup")
    public String userSignup(SignUpRequest dto, Model model) {
        System.out.println("comSignup called");
        System.out.println(dto);

        boolean identity = createUserIdentityCommandHandler.handle(dto);
//        if (!identity) {
//            System.out.println("중복된 이메일");
//            model.addAttribute("msg", "중복된 이메일 입니다.");
//            model.addAttribute("url", "/signup");
//            return "error";
//        }
        System.out.println("signup end point = "+identity);
        return "redirect:/";
    }
}
