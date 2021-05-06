package com.biman.makingJavaMoreFunc.m3_3absItr.sol3_11;


import java.util.ArrayList;
import java.util.List;

public class Range {
  public static List<Integer> range(int start, int end) {
    List<Integer> result = new ArrayList<>();
    int temp = start;
    while (temp < end) {
      result = CollectionUtitlities.append(result, temp);
      temp++;
    }
    return result;
  }
}
