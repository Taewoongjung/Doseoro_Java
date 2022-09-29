package com.myproject.doseoro.application.global.util.session;

import com.myproject.doseoro.domain.identity.vo.AccessUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class AccessUserSessionManager {
    private static final String USER_SESSION_KEY = "ACCESS_USER";

    private final HttpServletRequest servletRequest;
    public static Map<String, String> sessionStore = new ConcurrentHashMap<>();

    public void saveUser(AccessUserVO accessUser) {

        String sessionId = UUID.randomUUID().toString();
        System.out.println("@@@ = " + sessionId);

        servletRequest.getSession().setAttribute(USER_SESSION_KEY, accessUser.getUserId());
        servletRequest.getSession().setAttribute("email", accessUser.getEmail());
        servletRequest.getSession().setAttribute("nickName", accessUser.getNickName());

        sessionStore.put(USER_SESSION_KEY, accessUser.getUserId());
        System.out.println("뭐가 있지 = "+sessionStore.get(USER_SESSION_KEY));
    }

    public String extractUser() {
        return sessionStore.get(USER_SESSION_KEY);
    }
}
