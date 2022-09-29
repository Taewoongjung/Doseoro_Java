package com.myproject.doseoro.application.abstraction;

public interface CommandHandler<T, R> {

    public R handle(T t);
}
