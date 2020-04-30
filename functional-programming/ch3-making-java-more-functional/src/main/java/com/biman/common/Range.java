package com.biman.common;


import java.util.List;

import static com.biman.common.CollectionUtitlities.append;
import static com.biman.common.CollectionUtitlities.list;
import static com.biman.common.TailCall.ret;
import static com.biman.common.TailCall.sus;

public class Range {
  public static List<Integer> range(int start, int end) {
    return range_(list(),start,end).eval();
  }

  public static TailCall<List<Integer>> range_(List<Integer> acc, int start, int end) {
    return end <= start
        ? ret(acc)
        : sus( () -> range_(append(acc,start), start+1, end));
  }
}
