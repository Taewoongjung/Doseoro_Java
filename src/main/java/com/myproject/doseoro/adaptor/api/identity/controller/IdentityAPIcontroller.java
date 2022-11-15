package com.myproject.doseoro.adaptor.api.identity.controller;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.identity.handler.AuthenticateUserCommandHandler;
import com.myproject.doseoro.application.identity.handler.CreateUserIdentityCommandHandler;
import com.myproject.doseoro.application.identity.handler.RemoveUserSessionCommandHandler;
import com.myproject.doseoro.application.identity.vo.IdentityVO;
import com.myproject.doseoro.application.identity.vo.SignUpVO;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
@RequiredArgsConstructor
public class IdentityAPIcontroller {

    private final CreateUserIdentityCommandHandler createUserIdentityCommandHandler;
    private final AuthenticateUserCommandHandler authenticateUserCommandHandler;
    private final RemoveUserSessionCommandHandler removeUserSessionCommandHandler;

    @Logging
    @PostMapping(value = "/auth/signup")
    public String userSignup(SignUpVO vo) {
        createUserIdentityCommandHandler.handle(vo);
        return "redirect:/";
    }

    @Logging
    @GetMapping("/auth/login")
    public String login(@ModelAttribute IdentityVO vo) {
        boolean result = authenticateUserCommandHandler.handle(vo);
        if (!result) {
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @Logging
    @GetMapping("/auth/logout")
    public String logout(HttpSession session) {
        removeUserSessionCommandHandler.handle(session);
        return "redirect:/";
    }
}
