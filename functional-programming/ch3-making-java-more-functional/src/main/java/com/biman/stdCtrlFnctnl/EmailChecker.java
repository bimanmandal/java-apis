package com.biman.stdCtrlFnctnl;

import java.util.regex.Pattern;

public class EmailChecker {
  final Pattern emailPattern = Pattern.compile("^[a-z0-0._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  void testMail(String email) {
    if (emailPattern.matcher(email).matches()) {
      sendVerificationMail(email);
    } else {
      logError("email " + email + " is invalid");
    }
  }

  void sendVerificationMail(String email) {
    System.out.println("Verification mail sent to " + email);
  }

  void logError(String s) {
    System.err.println("Error message logged " + s);
  }


}
