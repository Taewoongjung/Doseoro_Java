package com.myproject.doseoro.api.identity.controller;

import com.myproject.doseoro.packages.identity.vo.SignUpVO;
import com.myproject.doseoro.packages.identity.vo.IdentityVO;
import com.myproject.doseoro.packages.identity.handler.AuthenticateUserCommandHandler;
import com.myproject.doseoro.packages.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.packages.identity.handler.RemoveUserSessionCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller()
@RequiredArgsConstructor
public class IdentityAPIcontroller {

    private final CreateUserIdentityCommandHandler createUserIdentityCommandHandler;
    private final AuthenticateUserCommandHandler authenticateUserCommandHandler;
    private final RemoveUserSessionCommandHandler removeUserSessionCommandHandler;

    @PostMapping(value = "/auth/signup")
    public String userSignup(@Valid SignUpVO vo, Model model) {
        System.out.println("comSignup called");
        System.out.println(vo);

        boolean identity = createUserIdentityCommandHandler.handle(vo);
        System.out.println("signup end point = " + identity);
        return "redirect:/";
    }

    @GetMapping("/auth/login")
    public String login(@ModelAttribute IdentityVO vo) {
        System.out.println("try login");
        boolean result = authenticateUserCommandHandler.handle(vo);
        if (!result) {
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @GetMapping("/auth/logout")
    public String logout(HttpSession session) {
        System.out.println(session.getId());
        removeUserSessionCommandHandler.handle(session);
        return "redirect:/";
    }
}
