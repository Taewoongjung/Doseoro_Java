package com.myproject.doseoro.application.global.util.loginInterceptor;

import com.myproject.doseoro.adaptor.logger.Logging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Logging
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("interceptor run");
        String requestURI = request.getRequestURI();
        log.info("인증 체크 인터셉터 실행 {}", requestURI);

        /**
         * filter는 인증이 필요없는 resource의 경우,
         * String[] whiteList = {"/", "/members/add", "/login", "/logout", "/css/*"}를 사용하여 처리했지만,
         * interceptor는 @Configuration으로 설정 가능
         */
        HttpSession session = request.getSession();
        if (isEmpty(session) || isEmpty(session.getAttribute("email"))) {
            log.info("미인증 사용자 요청");
            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }

        return true;
    }
}
