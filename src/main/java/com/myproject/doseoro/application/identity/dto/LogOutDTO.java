package com.myproject.doseoro.application.identity.dto;

import java.io.Serializable;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LogOutDTO implements Serializable {

    HttpSession session;
    HttpServletResponse response;

}
