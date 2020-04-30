package com.biman.recCorecMemo.m4_1UndRecNCorec;

public class ApplicationMain {
  public static void main(String[] args) {
//    TailCall<Integer> tailCall = Add.add(3,1000000);
//    while (tailCall.isSuspend()) {
//      tailCall = tailCall.resume();
//    }
//    System.out.println(tailCall.eval());
    System.out.println(Add.add.apply(3,1000000));

  }
}
