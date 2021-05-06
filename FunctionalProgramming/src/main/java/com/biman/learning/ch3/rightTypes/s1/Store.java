package com.biman.learning.ch3.rightTypes.s1;

import java.util.List;

import static com.biman.learning.ch3.abstractingIteration.CollectionUtilities.foldLeft;
import static com.biman.learning.ch3.abstractingIteration.CollectionUtilities.list;

public class Store {
    public static void main(String[] args) {
        Product toothPaste = new Product("Tooth Paste", 1.5, 0.5);
        Product toothBrush = new Product("Tooth brush", 3.5, 0.3);
        List<OrderLine> order = list(
                new OrderLine(toothPaste,2),
                new OrderLine(toothBrush, 3));
        double weight = foldLeft(order, 0.0, x -> y -> x + y.getWeight());
        double price = foldLeft(order, 0.0, x -> y -> x + y.getAmount());
        System.out.println(String.format("Total Price: %s", price));
        System.out.println(String.format("Total Weight: %s", weight));
    }
}
