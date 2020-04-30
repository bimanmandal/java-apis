package com.biman.dataHandlingWithLists.m5_2singlyLinkedList.s5_11;

import com.biman.dataHandlingWithLists.m5_2singlyLinkedList.List;

public class Solutions {
  public static Integer sumViaFoldLeft(List<Integer> list) {
    return list.foldLeft(0, x -> y -> x + y);
  }

  public static Double productViaFoldLeft(List<Double> list) {
    return list.foldLeft(1.0, x -> y -> x * y);
  }

  public static <A> Integer lengthViaFoldLeft(List<A> list) {
    return list.foldLeft(0, x -> ignore -> x + 1 );
  }
}
