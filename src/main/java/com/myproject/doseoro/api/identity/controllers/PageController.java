package com.myproject.doseoro.api.identity.controllers;

import com.myproject.doseoro.infra.mybatis.IdentityMybatisRepository;
import com.myproject.doseoro.packages.identity.domain.Identity;
import com.myproject.doseoro.packages.identity.dto.IdentityResponse;
import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PageController {
    IdentityMybatisRepository identityMybatisRepository;

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
    public String signup(Map<String, Object> model) {
        System.out.println("signup called");
        return "signup";
    }

    private final CreateUserIdentityCommandHandler createUserIdentityCommandHandler;

    @PostMapping(value = "/auth/signup")
    public String comSignup(final SignUpRequest dto) throws Exception {
        System.out.println("comSignup called");
        final Identity identity = createUserIdentityCommandHandler.signUp(dto);
        new IdentityResponse(identity.getId());
        return "home";
    }

    @PostMapping(value = "/find")
    public boolean findAllByEmail() {
        return identityMybatisRepository.existsByEmail();
    }
}
