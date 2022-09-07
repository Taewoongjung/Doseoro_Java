package com.myproject.doseoro.packages.identity.dto;

import lombok.Getter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Getter
public class LogOutDTO {
    HttpSession session;
    HttpServletResponse response;

    public LogOutDTO(HttpSession session, HttpServletResponse response) {
        this.session = session;
        this.response = response;
    }
}
