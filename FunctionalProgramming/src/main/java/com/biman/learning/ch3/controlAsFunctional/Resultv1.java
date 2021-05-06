package com.biman.learning.ch3.controlAsFunctional;

public interface Resultv1 {
    public class Success implements Resultv1 {}

    public class Failure implements Resultv1 {
        private final String errorMessage;

        public Failure(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
