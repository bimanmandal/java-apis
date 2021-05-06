package com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.m_3_2_2;

import java.util.function.Function;
import java.util.regex.Pattern;

import static com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.m_3_2_2.Case.match;
import static com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.m_3_2_2.Case.mcase;

public class EmailChecker {
  static Pattern emailPattern = Pattern.compile("^[a-z0-0._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  static final Function<String, Result> emailChecker = s -> match(
          mcase(() -> Result.success(s)),
          mcase(() -> (s == null), () -> Result.failure("email must not be null")),
          mcase(() -> (s.length() == 0), () -> Result.failure("email must not be empty")),
          mcase(() -> emailPattern.matcher(s).matches(), () -> Result.failure(s + " is invalid"))
  );

  private static Effect<String> success = (email) ->
      System.out.println("Verification mail sent to " + email);

  private static Effect<String> failure = (errorMessage) ->
      System.err.println("Error message logged " + errorMessage);


  public static void main(String[] args) {
    emailChecker.apply("john.doe@acme.com").bind(success, failure);
    emailChecker.apply(null).bind(success, failure);
    emailChecker.apply("").bind(success, failure);
    emailChecker.apply("paul.smith@acme.com").bind(success, failure);
  }

}
