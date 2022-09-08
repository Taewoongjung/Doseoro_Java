package com.myproject.doseoro.packages.book.handler;

import com.myproject.doseoro.packages.abstraction.ICommandHandler;
import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;

public class RegisterBookCommandHandler implements ICommandHandler<RegisterBookDTO, Boolean> {

    @Override
    public Boolean handle(RegisterBookDTO dto) {
        return null;
    }
}
