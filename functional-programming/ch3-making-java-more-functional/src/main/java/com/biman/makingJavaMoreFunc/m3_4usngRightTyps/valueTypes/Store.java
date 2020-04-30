package com.biman.makingJavaMoreFunc.m3_4usngRightTyps.valueTypes;

import java.util.List;

import static com.biman.makingJavaMoreFunc.m3_4usngRightTyps.valueTypes.CollectionUtitlities.foldLeft;
import static com.biman.makingJavaMoreFunc.m3_4usngRightTyps.valueTypes.CollectionUtitlities.list;

public class Store {
  public static void main(String[] args) {
    Product toothPaste = new Product("Tooth Paste", Price.price(1.5), Weight.weight(0.5));
    Product toothBrush = new Product("Tooth Brush", Price.price(3.5), Weight.weight(0.3));
    List<OrderLine> order = list(
        new OrderLine(toothPaste, 2),
        new OrderLine(toothBrush, 3));
    Weight weight = foldLeft(order, Weight.ZERO, x -> y -> x.add(y.getWeight()));
    Price amount = foldLeft(order, Price.ZERO, x -> y -> x.add(y.getAmount()));
    System.out.println(String.format("Total Price is : %s", amount.value));
    System.out.println(String.format("Total Weight is : %s", weight.value));
  }
}
