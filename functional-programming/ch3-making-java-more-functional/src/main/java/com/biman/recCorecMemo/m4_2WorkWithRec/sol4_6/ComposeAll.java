package com.biman.recCorecMemo.m4_2WorkWithRec.sol4_6;

import java.util.List;
import java.util.function.Function;

import static com.biman.common.CollectionUtitlities.*;
import static com.biman.common.Range.range;

public class ComposeAll {
  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return foldRight(list, Function.identity(), x -> y -> x.compose(y));
  }

  static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return x -> foldLeft(list, x, a -> b -> b.apply(a));
  }

  static <T> Function<T, T> composeViaFoldRight(List<Function<T, T>> list) {
    return x -> foldRight(list, x, a -> a::apply);
  }

  public static void main(String[] args) {
    Function<Integer, Integer> add = y -> y + 1;
    System.out.println(composeAllViaFoldLeft(map(range(0, 10000), x -> add)).apply(0));
  }
}
