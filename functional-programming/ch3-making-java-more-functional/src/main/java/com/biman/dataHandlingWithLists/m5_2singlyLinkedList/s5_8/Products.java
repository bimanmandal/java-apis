package com.biman.dataHandlingWithLists.m5_2singlyLinkedList.s5_8;

import com.biman.dataHandlingWithLists.m5_2singlyLinkedList.s5_1.List;

public class Products {
  public static Double product(List<Double> ds) {
    return ds.isEmpty()
        ? 1.0
        : ds.head() * product(ds.tail());
  }

  public static Double product2(List<Double> ds) {
    return ds.isEmpty()
        ? 1.0
        : ds.head() == 0
            ? 0
            : ds.head() * product2(ds.tail());
  }
}
