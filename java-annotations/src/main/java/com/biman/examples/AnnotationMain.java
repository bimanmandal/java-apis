package com.biman.examples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationMain {
    public static void main(String[] args) {
        new CustomAnnotationsImplementation();
        Class<CustomAnnotationsImplementation> classObj = CustomAnnotationsImplementation.class;
        printDetailsAboutAnnotations(classObj.getDeclaredMethods());
    }

    public static void printDetailsAboutAnnotations(Method[] methods){
        for (Method method: methods){
            System.out.println(method.getName()+ "===");
            for (Annotation annotation: method.getAnnotations()){
                if (annotation instanceof CustomAnnotations){
                    CustomAnnotations customAnnotations = (CustomAnnotations) annotation;
                    System.out.println(customAnnotations.value());
                }
            }
        }
    }
}
