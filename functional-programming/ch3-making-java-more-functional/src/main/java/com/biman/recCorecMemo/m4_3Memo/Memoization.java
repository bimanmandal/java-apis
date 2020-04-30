package com.biman.recCorecMemo.m4_3Memo;


import com.biman.common.TailCall;

import java.math.BigInteger;
import java.util.List;

import static com.biman.common.CollectionUtitlities.*;
import static com.biman.common.TailCall.ret;
import static com.biman.common.TailCall.sus;

public class Memoization {

  public static String fibo(int number) {
    List<BigInteger> list = fibo_(list(), BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(number)).eval();
    return mkString(list, ",");

  }

  public static TailCall<List<BigInteger>> fibo_(List<BigInteger> acc, BigInteger acc1, BigInteger acc2,
                                                 BigInteger x) {
    return x.equals(BigInteger.ZERO)
        ? ret(acc)
        : x.equals(BigInteger.ONE)
        ? ret(append(acc, acc1.add(acc2)))
        : sus(() -> fibo_(acc, acc2, acc1.add(acc2), x.subtract(BigInteger.ONE)));
  }

  public static <T> String mkString(List<T> list, String seperator) {
    return
        list.isEmpty()
            ? ""
            : tail(list).isEmpty()
            ? head(list).toString()
            : head(list) + foldLeft(tail(list), "", x -> y -> x + seperator + y);
  }



}
