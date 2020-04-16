package com.biman.absCntrlStruct;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailChecker {
  static Pattern emailPattern = Pattern.compile("^[a-z0-0._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  static final Function<String, Result> emailChecker = s -> {
    if (s == null)
      return new Result.Failure("email must not be null");
    else if (s.length() == 0)
      return new Result.Failure("email must not be empty");
    else if (emailPattern.matcher(s).matches())
      return new Result.Success();
    else
      return new Result.Failure("email " + s + " is invalid");
  };

  private static void sendVerificationMail(String email) {
    System.out.println("Verification mail sent to " + email);
  }

  private static void logError(String s) {
    System.err.println("Error message logged " + s);
  }

  static void validate(String s) {
    Result result = emailChecker.apply(s);
    if (result instanceof Result.Success) {
      sendVerificationMail(s);
    } else {
      logError(((Result.Failure) result).getErrorMessage());
    }
  }

  public static void main(String[] args) {
    validate("john.doe@acme.com");
    validate(null);
    validate("");
    validate("paul.smith@acme.com");
  }

}
