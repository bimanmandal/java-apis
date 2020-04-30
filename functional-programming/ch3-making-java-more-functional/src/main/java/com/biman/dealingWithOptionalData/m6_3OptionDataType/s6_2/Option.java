package com.biman.dealingWithOptionalData.m6_3OptionDataType.s6_2;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Option<A> {

  @SuppressWarnings("rawtypes")
  private static Option none = new None();
  public abstract A getOrThrow();
  public abstract A getOrElse(Supplier<A> defaultValue);
  public abstract <B> Option<B> map(Function<A, B> f);

  public <B> Option<B> flatMap(Function<A, Option<B>> f) {
    return map(f).getOrElse(Option::none);
  }

  public Option<A> orElse(Supplier<Option<A>> defaultValue) {
    return map(x -> this).getOrElse(defaultValue);
  }

  public Option<A> filter(Function<A, Boolean> f) {
    return flatMap(x -> f.apply(x)
        ? this
        : none());
  }

  private static class None<A> extends Option<A> {
    public None() {}

    @Override
    public A getOrThrow() {
      throw new IllegalStateException("get called on None");
    }

    @Override
    public A getOrElse(Supplier<A> defaultValue) {
      return defaultValue.get();
    }

    @Override
    public <B> Option<B> map(Function<A, B> f) {
      return none();
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
    public A getOrElse(Supplier<A> defaultValue) {
      return this.value;
    }

    @Override
    public <B> Option<B> map(Function<A, B> f) {
      return new Some<>(f.apply(this.value));
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
