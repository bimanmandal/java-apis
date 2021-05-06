package com.biman.learning.ch3.controlAsFunctional;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidationFunctionalv4 {
    static final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Result<String>> emailChecker = s ->
            //@formatter:off
            s == null
                ? Result.failure("email must not be null")
                : s.length() == 0
                    ? Result.failure("email must not be empty")
                    : emailPattern.matcher(s).matches()
                        ? Result.success(s)
                        : Result.failure("email " + s + " is invalid.");
            //@formatter:on


    static Effect<String> sucess = s -> System.out.println("Verification mail sent to " + s);
    static Effect<String> failure = s -> System.err.println("Error message logged: " + s);


    public static void main(String[] args) {
        emailChecker.apply("this.is@my.email").bind(sucess,failure);
        emailChecker.apply(null).bind(sucess,failure);
        emailChecker.apply("").bind(sucess,failure);
        emailChecker.apply("john.doe@acme.com").bind(sucess,failure);
    }


}
