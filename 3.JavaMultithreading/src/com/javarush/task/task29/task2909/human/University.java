package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {

        Student result = null;
        for (Student student :students) {
            if (student.getAverageGrade() == averageGrade) result = student;
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {

        Student result = null;
        double maxAverageGrade = 0;
        for (Student student :students) {
            if (student.getAverageGrade() > maxAverageGrade) {
                result = student;
                maxAverageGrade = student.getAverageGrade();
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {

        Student result = null;
        double minAverageGrade = students.get(0).getAverageGrade();
        for (Student student :students) {
            if (student.getAverageGrade() < minAverageGrade) {
                result = student;
                minAverageGrade = student.getAverageGrade();
            }
        }
        return result;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}