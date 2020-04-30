package com.biman.dealingWithOptionalData.m6_3OptionDataType.s6_1;

public abstract class Option<A> {

  @SuppressWarnings("rawtypes")
  private static Option none = new None();
  public abstract A getOrThrow();
  public abstract A getOrElse(A defaultValue);

  private static class None<A> extends Option<A> {
    public None() {}

    @Override
    public A getOrThrow() {
      throw new IllegalStateException("get called on None");
    }

    @Override
    public A getOrElse(A defaultValue) {
      return defaultValue;
    }

    @Override
    public String toString() {
      return "None";
    }
  }

  private static class Some<A> extends Option<A> {
    private final A value;

    public Some(A value) {
      this.value = value;
    }

    @Override
    public A getOrThrow() {
      return null;
    }

    @Override
    public A getOrElse(A defaultValue) {
      return this.value;
    }

    @Override
    public String toString() {
      return String.format("Some(%s)", this.value);
    }
  }

  public static <A> Option<A> some(A a) {
    return new Some<A>(a);
  }

  @SuppressWarnings("unchecked")
  public static <A> Option<A> none() {
    return none;
  }

}
