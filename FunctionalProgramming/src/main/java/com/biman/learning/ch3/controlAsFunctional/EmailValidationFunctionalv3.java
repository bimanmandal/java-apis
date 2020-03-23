package com.biman.learning.ch3.controlAsFunctional;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidationFunctionalv3 {
    static final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Resultv1> emailChecker = s ->
            //@formatter:off
            s == null
                ? new Resultv1.Failure("email must not be null")
                : s.length() == 0
                    ? new Resultv1.Failure("email must not be empty")
                    : emailPattern.matcher(s).matches()
                        ? new Resultv1.Success()
                        : new Resultv1.Failure("email " + s + " is invalid.");
            //@formatter:on


    private static void logError(String s) {
        System.err.println("Error message logged: " + s);
    }

    private static void sendVerificationMail(String email) {
        System.out.println("Verification mail sent to " + email);
    }

    static Executable validate(String email) {
        Resultv1 result = emailChecker.apply(email);
        return (result instanceof Resultv1.Success)
                ? () -> sendVerificationMail(email)
                : () -> logError(((Resultv1.Failure) result).getErrorMessage());
    }


    public static void main(String[] args) {
        validate("this.is@my.email").exec();
        validate(null).exec();
        validate("").exec();
        validate("john.doe@acme.com").exec();

    }


}
