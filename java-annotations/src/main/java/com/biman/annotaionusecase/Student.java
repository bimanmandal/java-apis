package com.biman.annotaionusecase;

public class Student {
    private int rollNo;
    private String name;

    // Try commenting the below annotation, it will throw exception while calculating pass/ fail
//    @ValidMarks
    @ValidMarks(minValue = 1,maxValue = 10)
    private int marks;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }


    public void setMarks(int marks) {
        this.marks = marks;
    }
}
