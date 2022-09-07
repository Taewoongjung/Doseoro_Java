package com.myproject.doseoro.packages.identity.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class RemoveUserSessionCommandHandler implements ICommandHandler<HttpSession, Void> {

    @Override
    public Void handle(HttpSession session) {
        session.invalidate();
        return null;
    }
}
