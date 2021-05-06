package com.biman.makingJavaMoreFunc.m3_4usngRightTyps.valueTypes;

public class Price {
  public final double value;

  public Price(double value) {
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
    if (value <= 0) {
      throw new IllegalArgumentException("Price must be greater than 0");
    }
    return new Price(value);
  }
}
