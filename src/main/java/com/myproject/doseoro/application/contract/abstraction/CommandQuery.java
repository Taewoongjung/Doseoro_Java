package com.myproject.doseoro.application.contract.abstraction;

public interface CommandQuery<T, R> {

    public R query(T t);
}
