package com.biman.learning.ch3.controlAsFunctional;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidationFunctional {
    final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    final Function<String, Boolean> emailChecker = s ->
            emailPattern.matcher(s).matches();

    void testMail(String email) {
        if (emailChecker.apply(email)) {
            sendVerificationMail(email);
        } else {
            logError("email : " + email + " is invalid. ");
        }
    }

    private void logError(String s) {
        System.out.println("Error message logged: " + s);
    }

    private void sendVerificationMail(String email) {
        System.out.println("Verification mail sent to " + email);
    }
}
