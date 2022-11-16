package com.myproject.doseoro.application.contract.abstraction;

public interface CommandHandler<T, R> {

    public R handle(T t);
}
