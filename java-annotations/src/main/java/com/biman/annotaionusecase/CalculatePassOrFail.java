package com.biman.annotaionusecase;

import java.lang.reflect.Field;

public class CalculatePassOrFail {

    public static CalculatePassOrFail getObject(){
        return new CalculatePassOrFail();
    }

    public boolean getResult(Object object) throws IllegalAccessException {
        validateObject(object);
        return calculateResult(object);
    }

    private boolean calculateResult(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Field field:clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ValidMarks.class)) {
                return (int) field.get(object) > 34;
            }
        }

        return false;

    }

    private void validateObject(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        boolean ifContainsMarksAnnotations = false;
        for (Field field:clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ValidMarks.class)){
                if (field.getAnnotation(ValidMarks.class).maxValue() < (int) field.get(object) ||
                        field.getAnnotation(ValidMarks.class).minValue() > (int) field.get(object)){
                    throw new IllegalArgumentException(
                            field.getName()
                                    + " should be within "
                                    +field.getAnnotation(ValidMarks.class).minValue()
                                    + " and "+ field.getAnnotation(ValidMarks.class).maxValue());
                }
                ifContainsMarksAnnotations = true;
            }
        }

        if (!ifContainsMarksAnnotations)
            throw new IllegalStateException(" Annotaion "+ValidMarks.class.getName() + " is absent");
    }
}

