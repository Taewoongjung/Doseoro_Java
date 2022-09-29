package com.myproject.doseoro.application.identity.handler;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.abstraction.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class RemoveUserSessionCommandHandler implements CommandHandler<HttpSession, Void> {

    @Logging
    @Override
    public Void handle(HttpSession session) {
        session.invalidate();
        return null;
    }
}
