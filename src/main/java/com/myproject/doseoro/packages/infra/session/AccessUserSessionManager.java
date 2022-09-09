package com.myproject.doseoro.packages.infra.session;

import com.myproject.doseoro.packages.identity.vo.AccessUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class AccessUserSessionManager {
    private static final String USER_SESSION_KEY = "ACCESS_USER";
    private final HttpServletRequest servletRequest;
    public static Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void saveUser(AccessUser accessUser) {

        String sessionId = UUID.randomUUID().toString();

        servletRequest.getSession().setAttribute(sessionId, accessUser.getUserId());
        servletRequest.getSession().setAttribute("email", accessUser.getEmail());
        servletRequest.getSession().setAttribute("nickName", accessUser.getNickName());

        sessionStore.put("email", accessUser.getEmail());
        System.out.println("뭐가 있지 = "+sessionStore.get(sessionId));
    }

    public AccessUser extractUser() {
        return (AccessUser) servletRequest.getSession().getAttribute(USER_SESSION_KEY);
    }
}
