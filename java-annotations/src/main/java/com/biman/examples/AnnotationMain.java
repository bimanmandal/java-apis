package com.biman.examples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationMain {
    public static void main(String[] args) throws IllegalAccessException {
        Class<CustomAnnotationsImplementation> classObj = CustomAnnotationsImplementation.class;

        Student student = new Student("Biman",1);

        System.out.println(student);

        Class<Student> studentClass = Student.class;
        for (Field field : studentClass.getDeclaredFields()){
            System.out.println("Getting Field");
            field.setAccessible(true);
            System.out.println(field.get(student));
            System.out.println(field.getName());
        }
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
