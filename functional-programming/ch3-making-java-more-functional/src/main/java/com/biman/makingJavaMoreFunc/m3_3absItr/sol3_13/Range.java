package com.biman.makingJavaMoreFunc.m3_3absItr.sol3_13;


import java.util.List;

public class Range {
  public static List<Integer> range(int start, int end) {
    return CollectionUtitlities.unfold(start, x -> x + 1, x -> x < end);
  }
}
