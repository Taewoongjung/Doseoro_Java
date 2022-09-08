package com.myproject.doseoro.packages.infra.session;

import com.myproject.doseoro.packages.identity.vo.AccessUser;
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
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void saveUser(AccessUser accessUser) {

        String sessionId = UUID.randomUUID().toString();

        servletRequest.getSession().setAttribute(sessionId, accessUser.getUserId());
        servletRequest.getSession().setAttribute("email", accessUser.getEmail());
        servletRequest.getSession().setAttribute("nickName", accessUser.getNickName());

        sessionStore.put(sessionId, accessUser);
    }

    public AccessUser extractUser() {
        return (AccessUser) servletRequest.getSession().getAttribute(USER_SESSION_KEY);
    }
}
