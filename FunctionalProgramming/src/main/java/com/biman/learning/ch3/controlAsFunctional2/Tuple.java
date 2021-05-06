package com.biman.learning.ch3.controlAsFunctional2;

import java.util.Objects;
import java.util.function.Function;

public class Tuple<T,U> {

    public final T _1;
    public final U _2;

    public Tuple(T t, U u) {
        _1 = Objects.requireNonNull(t);
        _2 = Objects.requireNonNull(u);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", _1, _2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("rawtypes")
        Tuple that = (Tuple) o;
        return _1.equals(that._1) && _2.equals(that._2);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + _1.hashCode();
        result = prime * result + _2.hashCode();
        return result;
    }

    public Tuple<U,T> swap(){
        return new Tuple<>(_2,_1);
    }

    public static <T> Tuple<T,T> swapIf(Tuple<T,T> t, Function<T,Function<T,Boolean>> p) {
        return p.apply(t._1).apply(t._2) ? t.swap() : t;
    }
}
