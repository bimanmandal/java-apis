package com.biman.learning.ch3.rightTypes.s2;

import java.util.function.Function;

public class Price {
    public final double value;

    private Price(double value) {
        this.value = value;
    }

    public Price add(Price that) {
        return new Price(this.value + that.value);
    }

    public Price mult(int count) {
        return new Price(this.value * count);
    }

    public static final Price ZERO = new Price(0.0);

    public static Price price(double value) {
        if(value <= 0){
            throw new IllegalStateException("Price must be greater than 0");
        }
        return new Price(value);
    }

    public static Function<Price, Function<OrderLine, Price>> sum = x -> y -> x.add(y.getAmount());

    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
