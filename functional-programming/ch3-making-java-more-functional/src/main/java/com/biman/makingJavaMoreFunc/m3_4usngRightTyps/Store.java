package com.biman.makingJavaMoreFunc.m3_4usngRightTyps;

import java.util.List;

import static com.biman.makingJavaMoreFunc.m3_4usngRightTyps.CollectionUtitlities.foldLeft;
import static com.biman.makingJavaMoreFunc.m3_4usngRightTyps.CollectionUtitlities.list;

public class Store {
  public static void main(String[] args) {
    Product toothPaste = new Product("Tooth Paste", 1.5, 0.5);
    Product toothBrush = new Product("Tooth Brush", 3.5, 0.3);
    List<OrderLine> order = list(
        new OrderLine(toothPaste, 2),
        new OrderLine(toothBrush, 3));
    double weight = foldLeft(order, 0.0, x -> y -> x + y.getWeight());
    double amount = foldLeft(order, 0.0, x -> y -> x + y.getAmount());
    System.out.println(String.format("Total Price is : %s", amount));
    System.out.println(String.format("Total Weight is : %s", weight));
  }
}
