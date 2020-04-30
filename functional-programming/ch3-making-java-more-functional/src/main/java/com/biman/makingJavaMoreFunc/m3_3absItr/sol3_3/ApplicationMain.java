package com.biman.makingJavaMoreFunc.m3_3absItr.sol3_3;

import java.util.List;
import java.util.function.Function;

import static com.biman.makingJavaMoreFunc.m3_3absItr.sol3_3.CollectionUtitlities.*;
public class ApplicationMain {
  private static String addIS( String s, Integer i){
    return String.format("(%s + %s)",s,i);
  }
  public static void main(String[] args) {
    List<Integer> list = list(1,2,3,4,5,6);
    int result = fold(list,0, x -> y -> x + y);
    System.out.println(result);

    String identity = "0";
    Function<String, Function<Integer, String>> f = x -> y -> addIS(x, y);
    String resultADDIS = CollectionUtitlities.<Integer,String>foldLeft(list,identity,f);
    System.out.println(resultADDIS);


  }
}
