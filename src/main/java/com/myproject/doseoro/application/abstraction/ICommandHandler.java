package com.myproject.doseoro.application.abstraction;

public interface ICommandHandler<T, R> {

    public R handle(T t);
}
