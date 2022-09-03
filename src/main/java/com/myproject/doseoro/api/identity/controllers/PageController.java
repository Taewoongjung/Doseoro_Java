package com.myproject.doseoro.api.identity.controllers;

import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String signup(Map<String, Object> model) {
        System.out.println("signup called");
        return "signup";
    }

//    @PostMapping(value = "/auth/signup")
//    public String comSignup(final SignUpRequest dto) throws Exception {
//        System.out.println("comSignup called");
//        final Identity identity = createUserIdentityCommandHandler.signUp(dto);
//        new IdentityResponse(identity.getId());
//        return "home";
//    }

    @RequestMapping(value = "/find")
    public void findAllByEmail() throws Exception {
        createUserIdentityCommandHandler.findThis();
    }
}
