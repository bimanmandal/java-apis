package com.biman.learning.ch3.controlAsFunctional;

import java.util.regex.Pattern;

public class EmailValidation {
    final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    void testEmail(String email) {
        if (emailPattern.matcher(email).matches()) {
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
