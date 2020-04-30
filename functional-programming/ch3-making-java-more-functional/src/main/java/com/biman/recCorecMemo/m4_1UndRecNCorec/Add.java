package com.biman.recCorecMemo.m4_1UndRecNCorec;

import com.biman.common.TailCall;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static com.biman.common.TailCall.ret;
import static com.biman.common.TailCall.sus;

public class Add {
  static int add(int x, int y) {
    return addRec(x, y).eval();
  }

  static TailCall<Integer> addRec(int x, int y) {
    return y == 0
        ? ret(x)
        : sus(() -> addRec(x + 1, y - 1));
  }

  static BiFunction<Integer, Integer, TailCall<Integer>> add2 = (x, y) ->
      y == 0
          ? ret(x)
          : sus(() -> Add.add2.apply(x + 1, y - 1));

  static BinaryOperator<Integer> add = (a, b) -> {
    class AddHelper {
      BiFunction<Integer, Integer, TailCall<Integer>> addHelper = (x, y) ->
          y == 0
              ? ret(x)
              : sus(() -> this.addHelper.apply(x + 1, y - 1));
    }
    return new AddHelper().addHelper.apply(a, b).eval();
  };
}
