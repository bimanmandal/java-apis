package com.biman.common;

import java.util.function.BiPredicate;

public class Tuple<T, U> {

  public final T _1;
  public final U _2;


  public Tuple(T t, U u) {
    _1 = t;
    _2 = u;
  }

  @Override
  public String toString() {
    return String.format("(%s,%s)", _1, _2);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tuple<?, ?> tuple = (Tuple<?, ?>) o;
    return _1.equals(tuple._1) &&
        _2.equals(tuple._2);
  }

  @Override
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = prime * result + _1.hashCode();
    result = prime * result + _2.hashCode();
    return result;
  }

  public Tuple<U, T> swap() {
    return new Tuple<>(_2, _1);
  }

  public static <T> Tuple<T, T> swapIf(Tuple<T, T> tuple, BiPredicate<T, T> p) {
    return p.test(tuple._1, tuple._2) ? tuple.swap() : tuple;
  }


}
