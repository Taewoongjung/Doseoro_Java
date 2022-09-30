package com.myproject.doseoro.application.identity.dto;

import lombok.Getter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Getter
public class LogOutDTO implements Serializable {
    HttpSession session;
    HttpServletResponse response;

    public LogOutDTO(HttpSession session, HttpServletResponse response) {
        this.session = session;
        this.response = response;
    }
}
