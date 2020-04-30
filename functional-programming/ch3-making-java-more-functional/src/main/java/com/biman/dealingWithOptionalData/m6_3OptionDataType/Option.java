package com.biman.dealingWithOptionalData.m6_3OptionDataType;

public abstract class Option<A> {

  @SuppressWarnings("rawtypes")
  private static Option none = new None();
  public abstract A getOrThrow();

  private static class None<A> extends Option<A> {
    public None() {}

    @Override
    public A getOrThrow() {
      throw new IllegalStateException("get called on None");
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
