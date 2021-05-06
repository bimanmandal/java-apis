package com.biman.learning.ch3.rightTypes.s2;

public class Product {
    private final String name;
    private final Weight weight;
    private final Price price;

    public Product(String name, Price price , Weight weight) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Weight getWeight() {
        return weight;
    }

    public Price getPrice() {
        return price;
    }
}
