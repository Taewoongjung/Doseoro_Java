package com.myproject.doseoro.api.identity.controllers;

import com.myproject.doseoro.packages.identity.dto.SignUpRequest;
import com.myproject.doseoro.packages.identity.dto.vo.IdentityVO;
import com.myproject.doseoro.packages.identity.handler.AuthenticateUserCommandHandler;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class APIcontroller {

    private final CreateUserIdentityCommandHandler createUserIdentityCommandHandler;
    private final AuthenticateUserCommandHandler authenticateUserCommandHandler;

    @PostMapping(value = "/auth/signup")
    public String userSignup(SignUpRequest dto, Model model) {
        System.out.println("comSignup called");
        System.out.println(dto);

        boolean identity = createUserIdentityCommandHandler.handle(dto);
        System.out.println("signup end point = " + identity);
        return "redirect:/";
    }

    @GetMapping("/auth/login")
    public String login(@ModelAttribute IdentityVO vo, HttpSession session) {
        System.out.println("try login");
        System.out.println("@@ = " + vo);
        boolean result = authenticateUserCommandHandler.handle(vo, session);
        ModelAndView mav = new ModelAndView();
        if (!result) {
            return "redirect:/login";
        }
        mav.addObject("identity", vo);
        System.out.println("login session = "+session.getId());
        System.out.println("login session = "+session.isNew());
        System.out.println("login session = "+session.getCreationTime());
        System.out.println("login session = "+session.getAttribute("email"));
        return "redirect:/";
    }

    @GetMapping("/auth/logout")
    public String logout(HttpSession session) {
        System.out.println("logout session = " + session.getId());
        System.out.println("logout session = " + session.isNew());
        System.out.println("logout session = " + session.getCreationTime());
        System.out.println("logout session = " + session.getAttribute("email"));
        authenticateUserCommandHandler.logout(session);
        return "redirect:/";
    }
}
