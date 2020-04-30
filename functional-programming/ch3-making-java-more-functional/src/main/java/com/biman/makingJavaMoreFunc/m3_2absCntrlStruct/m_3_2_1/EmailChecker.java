package com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.m_3_2_1;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailChecker {
  static Pattern emailPattern = Pattern.compile("^[a-z0-0._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  static final Function<String, Result> emailChecker = s ->
      (s == null)
          ? Result.failure("email must not be null")
          : (s.length() == 0)
          ? Result.failure("email must not be empty")
          : (emailPattern.matcher(s).matches())
          ? Result.success(s)
          : Result.failure("email " + s + " is invalid");

  private static Effect<String> success = (email) ->
    System.out.println("Verification mail sent to " + email);

  private static Effect<String> failure = (errorMessage) ->
    System.err.println("Error message logged " + errorMessage);


  public static void main(String[] args) {
    emailChecker.apply("john.doe@acme.com").bind(success,failure);
    emailChecker.apply(null).bind(success,failure);
    emailChecker.apply("").bind(success,failure);
    emailChecker.apply("paul.smith@acme.com").bind(success,failure);
  }

}
