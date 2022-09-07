package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.identity.dao.DoseoroDao;
import com.myproject.doseoro.packages.identity.vo.AccessUser;
import com.myproject.doseoro.packages.infra.manager.AccessUserSessionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
* https://a1010100z.tistory.com/194
* */

@SpringBootTest
class RemoveUserSessionCommandHandlerTest {

    MockHttpServletRequest servletRequest;
    AccessUserSessionManager userSessionManager;
    HttpServletResponse response;

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