package com.biman.dataHandlingWithLists.m5_2singlyLinkedList.s5_7;

import com.biman.dataHandlingWithLists.m5_2singlyLinkedList.s5_1.List;

public class Sum {
  public static Integer sum(List<Integer> ints) {
    return ints.isEmpty()
        ? 0
        : ints.head() + sum(ints.tail());
  }
}
