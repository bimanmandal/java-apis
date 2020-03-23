package com.biman.learning.ch3.rightTypes.s2;

import java.util.List;

import static com.biman.learning.ch3.abstractingIteration.CollectionUtilities.foldLeft;
import static com.biman.learning.ch3.abstractingIteration.CollectionUtilities.list;
import static com.biman.learning.ch3.rightTypes.s2.Price.price;
import static com.biman.learning.ch3.rightTypes.s2.Weight.weight;

public class Store {
    public static void main(String[] args) {
        Product toothPaste = new Product("Tooth Paste", price(1.5), weight(0.5));
        Product toothBrush = new Product("Tooth Brush", price(3.5), weight(0.3));
        List<OrderLine> order = list(new OrderLine(toothBrush,2),new OrderLine(toothPaste,3));
        Price price = foldLeft(order, Price.ZERO, Price.sum);
        Weight weight = foldLeft(order, Weight.ZERO, Weight.sum);
        System.out.println(String.format("Total Price is : %s",price));
        System.out.println(String.format("Total Weight is : %s",weight));
    }
}
