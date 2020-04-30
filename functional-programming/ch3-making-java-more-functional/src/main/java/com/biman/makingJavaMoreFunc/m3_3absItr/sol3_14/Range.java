package com.biman.makingJavaMoreFunc.m3_3absItr.sol3_14;


import java.util.List;

public class Range {
  public static List<Integer> range(int start, int end) {
    return end <= start
        ? CollectionUtitlities.list()
        : CollectionUtitlities.prepend(start, range(start + 1, end));
  }
}
