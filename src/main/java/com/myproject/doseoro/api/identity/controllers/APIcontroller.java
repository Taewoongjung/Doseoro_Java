package com.myproject.doseoro.api.identity.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class APIcontroller {

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
    public String login(@ModelAttribute IdentityVO vo, HttpSession session) {
        System.out.println("try login");
        System.out.println("@@ = " + vo);
        IdentityVO result = authenticateUserCommandHandler.handle(vo);
        ModelAndView mav = new ModelAndView();
        if (result == null) {
            return "redirect:/login";
        }
        session.setAttribute("email", result.getEmail());
        session.setAttribute("name", result.getNickName());
        mav.addObject("identity", vo);
        return "redirect:/";
    }

    @GetMapping("/auth/logout")
    public String logout(HttpSession session) {
        System.out.println("logout session = " + session.getId());
        System.out.println("logout session = " + session.isNew());
        System.out.println("logout session = " + session.getCreationTime());
        System.out.println("logout session = " + session.getAttribute("email"));
        removeUserSessionCommandHandler.handle(session);
        return "redirect:/";
    }
}
