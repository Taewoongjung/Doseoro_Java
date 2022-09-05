package com.myproject.doseoro.packages.identity.abstraction;

import com.myproject.doseoro.packages.identity.dto.vo.IdentityVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public abstract class IdentityService {
    abstract public IdentityVO viewUser(IdentityVO vo);

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
