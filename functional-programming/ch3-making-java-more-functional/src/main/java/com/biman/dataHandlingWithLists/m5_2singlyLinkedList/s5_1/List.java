package com.biman.dataHandlingWithLists.m5_2singlyLinkedList.s5_1;

import com.biman.common.TailCall;

import java.util.function.Function;

import static com.biman.common.TailCall.ret;
import static com.biman.common.TailCall.sus;

public abstract class List<A> {

  public abstract A head();

  public abstract List<A> tail();

  public abstract boolean isEmpty();

  public abstract List<A> setHead(A h);

  public abstract List<A> drop(int n);

  public abstract List<A> dropWhile(Function<A, Boolean> f);

  @SuppressWarnings("rawtypes")
  public static final List NIL = new Nil();

  private List() {
  }

  public List<A> cons(A a) {
    return new Cons<>(a, this);
  }

  public List<A> setHead(List<A> list, A h) {
    return list.setHead(h);
  }

  public static <A> List<A> concat(List<A> list1, List<A> list2) {
    return list1.isEmpty()
        ? list2
        : new Cons<>(list1.head(),concat(list1.tail(),list2));
  }

  public List<A> reverse() {
    return reverse_(list(), this).eval();
  }

  private TailCall<List<A>> reverse_(List<A> acc, List<A> list) {
    return list.isEmpty()
        ? ret(acc)
        : sus(() -> reverse_(new Cons<>(list.head(),acc),list.tail()));
  }

  public List<A> init() {
    return reverse().tail().reverse();
  }

  private static class Nil<A> extends List<A> {

    private Nil() {
    }

    @Override
    public A head() {
      throw new IllegalStateException("head called on empty list");
    }

    @Override
    public List<A> tail() {
      throw new IllegalStateException("tail called on empty list");
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public List<A> setHead(A h) {
      throw new IllegalStateException("setHead called on empty list");
    }

    @Override
    public List<A> drop(int n) {
      return this;
    }

    @Override
    public List<A> dropWhile(Function<A, Boolean> f) {
      return this;
    }

    @Override
    public String toString() {
      return "[NIL]";
    }
  }

  private static class Cons<A> extends List<A> {

    private final A head;
    private final List<A> tail;

    private Cons(A head, List<A> tail) {
      this.head = head;
      this.tail = tail;
    }

    @Override
    public A head() {
      return head;
    }

    @Override
    public List<A> tail() {
      return tail;
    }

    @Override
    public boolean isEmpty() {
      return false;
    }

    @Override
    public List<A> setHead(A h) {
      return new Cons<>(h, tail());
    }

    @Override
    public List<A> drop(int n) {
      return n <= 0
          ? this
          : drop_(this, n).eval();
    }

    private TailCall<List<A>> drop_(List<A> list, int n) {
      return n <= 0 || list.isEmpty()
          ? ret(list)
          : sus(() -> drop_(list.tail(), n - 1));
    }

    @Override
    public List<A> dropWhile(Function<A, Boolean> f) {
      return dropWhile_(this,f).eval();
    }

    private TailCall<List<A>> dropWhile_ (List<A> list, Function<A, Boolean> f) {
      return !list.isEmpty() && f.apply(list.head())
          ? sus(() -> dropWhile_(list.tail(), f))
          : ret(list);
    }


    @Override
    public String toString() {
      return String.format("[%sNIL]",
          toString(new StringBuilder(), this).eval());
    }

    private TailCall<StringBuilder> toString(StringBuilder acc, List<A> list) {
      return list.isEmpty()
          ? ret(acc)
          : sus(() -> toString(acc.append(list.head()).append(","), list.tail()));
    }
  }

  @SuppressWarnings("unchecked")
  public static <A> List<A> list() {
    return NIL;
  }

  @SafeVarargs
  public static <A> List<A> list(A... a) {
    List<A> n = list();
    for (int i = a.length - 1; i >= 0; i--) {
      n = new Cons<>(a[i], n);
    }
    return n;
  }
}
