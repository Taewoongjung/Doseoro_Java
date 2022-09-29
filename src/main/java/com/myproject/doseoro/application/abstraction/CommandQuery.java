package com.myproject.doseoro.application.abstraction;

public interface CommandQuery <T, R>{
    public R query(T t);
}
