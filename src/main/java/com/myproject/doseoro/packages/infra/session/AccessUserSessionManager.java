package com.myproject.doseoro.packages.infra.session;

import com.myproject.doseoro.packages.identity.vo.AccessUserVO;
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
    public Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void saveUser(AccessUserVO accessUser) {

        String sessionId = UUID.randomUUID().toString();

        servletRequest.getSession().setAttribute(sessionId, accessUser.getUserId());
        servletRequest.getSession().setAttribute("email", accessUser.getEmail());
        servletRequest.getSession().setAttribute("nickName", accessUser.getNickName());

        sessionStore.put(sessionId, accessUser.getUserId());
        System.out.println("뭐가 있지 = "+sessionStore.get(sessionId));
    }

    public AccessUserVO extractUser() {
        return (AccessUserVO) servletRequest.getSession().getAttribute(USER_SESSION_KEY);
    }
}
