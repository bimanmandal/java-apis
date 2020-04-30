package com.biman.makingJavaMoreFunc.m3_4usngRightTyps.valueTypes;

public class Weight {
  public final double value;

  public Weight(double value) {
    this.value = value;
  }

  public Weight add(Weight that) {
    return new Weight(this.value + that.value);
  }

  public Weight mult(int count) {
    return new Weight(this.value * count);
  }

  public static final Weight ZERO = new Weight(0.0);

  public static Weight weight(double value) {
    if (value < 0)
      throw new IllegalArgumentException("Weight must be greater than 0");
    return new Weight(value);
  }
}
