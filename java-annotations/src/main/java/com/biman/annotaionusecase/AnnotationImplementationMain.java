package com.biman.annotaionusecase;

public class AnnotationImplementationMain {
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student();
        CalculatePassOrFail calculatePassOrFail = CalculatePassOrFail.getObject();
        System.out.println(calculatePassOrFail.getResult(student));


//        student.setMarks(1000);
//        System.out.println(calculatePassOrFail.getResult(student));

        student.setMarks(-10);
        System.out.println(calculatePassOrFail.getResult(student));

    }
}
