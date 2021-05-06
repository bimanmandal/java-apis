package com.biman.examples;

//@CustomAnnotations
public class CustomAnnotationsImplementation {

    @CustomAnnotations("Life without Passing Value in Annotations")
    void printGreeting1(){
        System.out.println("Hello World1");
    }

    @CustomAnnotations
    void printGreeting2(){
        System.out.println("Hello World2");
    }

}
