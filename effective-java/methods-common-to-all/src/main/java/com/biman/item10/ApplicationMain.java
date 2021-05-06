package com.biman.item10;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {
  public static void main(String[] args) {
    System.out.println("Hello World");

    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String s = "polish";

    System.out.println(cis.equals(s));
    s.equals(cis); // False String is oblivious to case-insensitive string

    // Violation of symmetry

    List<CaseInsensitiveString> list = new ArrayList<>();
    list.add(cis);

    System.out.println(list.contains(s));


  }
}
