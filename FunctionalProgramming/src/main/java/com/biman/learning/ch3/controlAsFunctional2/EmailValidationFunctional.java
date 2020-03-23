package com.biman.learning.ch3.controlAsFunctional2;


import java.util.function.Function;
import java.util.regex.Pattern;

import static com.biman.learning.ch3.controlAsFunctional2.Case.match;
import static com.biman.learning.ch3.controlAsFunctional2.Case.mcase;
import static com.biman.learning.ch3.controlAsFunctional2.Result.failure;
import static com.biman.learning.ch3.controlAsFunctional2.Result.success;

public class EmailValidationFunctional {
    static final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Result<String>> emailChecker = s -> match(
            mcase(() -> success(s)),
            mcase(() -> s == null, () -> failure("email must not be null")),
            mcase(() -> s.length() == 0, () -> failure("email must not be empty")),
            mcase(() -> emailPattern.matcher(s).matches(), () -> failure("email " + s + " is invalid."))
    );


    static Effect<String> sucess = s -> System.out.println("Verification mail sent to " + s);
    static Effect<String> failure = s -> System.err.println("Error message logged: " + s);


    public static void main(String[] args) {
        emailChecker.apply("this.is@my.email").bind(sucess, failure);
        emailChecker.apply(null).bind(sucess, failure);
        emailChecker.apply("").bind(sucess, failure);
        emailChecker.apply("john.doe@acme.com").bind(sucess, failure);
    }


}
