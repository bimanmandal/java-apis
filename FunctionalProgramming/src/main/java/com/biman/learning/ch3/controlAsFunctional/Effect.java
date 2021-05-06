package com.biman.learning.ch3.controlAsFunctional;

public interface Effect<T> {
    void apply(T t);
}
