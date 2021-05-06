package com.biman.learning.ch3.controlAsFunctional2;

public interface Effect<T> {
    void apply(T t);
}
