package com.biman.learning.ch3.controlAsFunctional;

public class Application {
    public static void main(String[] args) {
        EmailValidationFunctional emailValidation = new EmailValidationFunctional();
        emailValidation.testMail("john.doe@acme.com");
        emailValidation.testMail(null);
        emailValidation.testMail("paul.smith@acme.com");
    }
}
