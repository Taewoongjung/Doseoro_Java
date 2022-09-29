package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.identity.handler.RemoveUserSessionCommandHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SpringBootTest
class RemoveUserSessionCommandHandlerTest {

    MockHttpServletRequest servletRequest;
    AccessUserSessionManager userSessionManager;

    @BeforeEach
    void setUp() {
        MockHttpSession httpSession = new MockHttpSession();
        servletRequest = new MockHttpServletRequest();
        servletRequest.setSession(httpSession);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(servletRequest));
        userSessionManager = new AccessUserSessionManager(servletRequest);
    }

    @Test
    @DisplayName("로그인 된 유저의 세션을 지우면서 로그아웃 시킬 수 있다.")
    @Transactional
    void commandHandler() {

        RemoveUserSessionCommandHandler removeUserSessionCommandHandler = new RemoveUserSessionCommandHandler();
        servletRequest.getSession().setAttribute("test-session", "test");

        removeUserSessionCommandHandler.handle(servletRequest.getSession());
    }
}