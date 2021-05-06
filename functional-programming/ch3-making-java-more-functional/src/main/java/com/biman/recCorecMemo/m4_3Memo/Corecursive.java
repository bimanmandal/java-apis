package com.biman.recCorecMemo.m4_3Memo;

import com.biman.common.Tuple;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

import static com.biman.common.CollectionUtitlities.*;

public class Corecursive {
  public static String fiboCorecursive(int num) {
    Tuple<BigInteger, BigInteger> seed = new Tuple<>(BigInteger.ZERO, BigInteger.ONE);
    Function<Tuple<BigInteger, BigInteger>, Tuple<BigInteger, BigInteger>> f =
        x -> new Tuple<>(x._2, x._1.add(x._2));
    List<BigInteger> list = map(iterate(seed, f, num + 1), x -> x._1);
    return mkString(list, ",");
  }

  public static <B> List<B> iterate(B seed, Function<B, B> f, int n) {
    List<B> result = list();
    B temp = seed;
    for (int i = 0; i < n; i++) {
      result = append(result, temp);
      temp = f.apply(temp);
    }
    return result;
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
