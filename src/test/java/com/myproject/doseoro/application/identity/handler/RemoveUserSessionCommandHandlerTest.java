package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RemoveUserSessionCommandHandlerTest {

    @Mock
    RemoveUserSessionCommandHandler removeUserSessionCommandHandler;
    @Mock
    private MockHttpServletRequest servletRequest;
    @Mock
    private AccessUserSessionManager userSessionManager;
    @Mock
    private MockHttpSession httpSession;

    @Test
    @DisplayName("로그인 된 유저의 세션을 지우면서 로그아웃 시킬 수 있다.")
    @Transactional
    void commandHandler() {

        servletRequest.setSession(httpSession);
        userSessionManager = new AccessUserSessionManager(servletRequest);

        when(servletRequest.getSession()).thenReturn(httpSession);
        servletRequest.getSession().setAttribute("test-session", "test");

        removeUserSessionCommandHandler.handle(servletRequest.getSession());
    }
}
