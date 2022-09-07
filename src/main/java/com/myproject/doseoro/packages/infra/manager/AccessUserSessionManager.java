package com.myproject.doseoro.packages.infra.manager;

import com.myproject.doseoro.packages.identity.vo.AccessUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class AccessUserSessionManager {
    private static final String USER_SESSION_KEY = "ACCESS_USER";
    private final HttpServletRequest servletRequest;
//    private final HttpServletResponse response;
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void saveUser(AccessUser accessUser) {

        String sessionId = UUID.randomUUID().toString();

        servletRequest.getSession().setAttribute(sessionId, accessUser.getUserId());
        servletRequest.getSession().setAttribute("email", accessUser.getEmail());
        servletRequest.getSession().setAttribute("nickName", accessUser.getNickName());

        sessionStore.put(sessionId, accessUser);

//        CookieGenerator cg = new CookieGenerator();
//
//        cg.setCookieName(USER_SESSION_KEY);
//        cg.addCookie(response, sessionId);
    }

    public AccessUser extractUser() {
        return (AccessUser) servletRequest.getSession().getAttribute(USER_SESSION_KEY);
    }
}
