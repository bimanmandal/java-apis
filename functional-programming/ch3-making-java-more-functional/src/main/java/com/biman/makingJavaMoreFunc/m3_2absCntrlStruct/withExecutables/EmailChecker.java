package com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.withExecutables;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailChecker {
  static Pattern emailPattern = Pattern.compile("^[a-z0-0._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  static final Function<String, Result> emailChecker = s ->
      (s == null)
          ? new Result.Failure("email must not be null")
          : (s.length() == 0)
          ? new Result.Failure("email must not be empty")
          : (emailPattern.matcher(s).matches())
          ? new Result.Success()
          : new Result.Failure("email " + s + " is invalid");

  private static void sendVerificationMail(String email) {
    System.out.println("Verification mail sent to " + email);
  }

  private static void logError(String s) {
    System.err.println("Error message logged " + s);
  }

  static Executable validate(String s) {
    Result result = emailChecker.apply(s);
    return (result instanceof Result.Success)
        ? (() -> sendVerificationMail(s))
        : (() -> logError(((Result.Failure) result).getMessage()));
  }

  public static void main(String[] args) {
    validate("john.doe@acme.com").exec();
    validate(null).exec();
    validate("").exec();
    validate("paul.smith@acme.com").exec();
  }

}
