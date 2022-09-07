package com.myproject.doseoro.packages.abstraction;

public interface ICommandHandler<T, R> {

    public R handle(T t);
}
