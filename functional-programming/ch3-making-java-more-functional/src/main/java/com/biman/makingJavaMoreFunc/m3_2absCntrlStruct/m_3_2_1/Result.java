package com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.m_3_2_1;

public interface Result<T> {

  void bind(Effect<T> success, Effect<T> failure);

  public static <T> Result<T> success(T value) {
    return new Success<>(value);
  }

  public static <T> Result<T> failure(T value) {
    return new Failure<>(value);
  }

  public class Success<T> implements Result<T> {
    private final T value;

    private Success(T value) {
      this.value = value;
    }

    @Override
    public void bind(Effect<T> success, Effect<T> failure) {
      success.apply(value);
    }
  }

  public class Failure<T> implements Result<T> {
    private final T value;

    private Failure(T value) {
    this.value  = value;
    }

    @Override
    public void bind(Effect<T> success, Effect<T> failure) {
      failure.apply(value);
    }
  }
}
