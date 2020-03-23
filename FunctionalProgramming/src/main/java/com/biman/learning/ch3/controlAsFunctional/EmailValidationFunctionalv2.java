package com.biman.learning.ch3.controlAsFunctional;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidationFunctionalv2 {
    static final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Resultv1> emailChecker = s -> {
        if (s == null) {
            return new Resultv1.Failure("email must not be null");
        } else if (s.length() == 0) {
            return new Resultv1.Failure("email must not be empty");
        } else if (emailPattern.matcher(s).matches()) {
            return new Resultv1.Success();
        } else {
            return new Resultv1.Failure("email " + s + " is invalid.");
        }
    };

    private static void logError(String s) {
        System.out.println("Error message logged: " + s);
    }

    private static void sendVerificationMail(String email) {
        System.out.println("Verification mail sent to " + email);
    }

    static void validate(String email) {
        Resultv1 result = emailChecker.apply(email);
        if (result instanceof Resultv1.Success) {
            sendVerificationMail(email);
        } else {
            logError(((Resultv1.Failure) result).getErrorMessage());
        }
    }

    public static void main(String[] args) {
        validate("this.is@my.email");
        validate(null);
        validate("");
        validate("john.doe@acme.com");

    }


}
