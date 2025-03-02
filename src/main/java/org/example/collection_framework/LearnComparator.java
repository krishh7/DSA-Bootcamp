package org.example.collection_framework;

import java.util.*;

class Student {
    String name;
    int rollNumber;
    int marks;

    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + rollNumber + " - " + marks;
    }

}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s2.name.compareTo(s1.name);
    }
}

class RollNumberComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s2.rollNumber - s1.rollNumber;
    }
}

class MarksComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s2.marks - s1.marks;
    }
}
public class LearnComparator {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Krishna", 111, 88),
                new Student("Vishal", 115, 87),
                new Student("Meghana", 131, 99),
                new Student("Adhi", 121, 77)
        );

        Collections.sort(students, new NameComparator());
        System.out.println(students);
        Collections.sort(students, new RollNumberComparator());
        System.out.println(students);
        Collections.sort(students, new MarksComparator());
        System.out.println(students);
        System.out.println("--------------------------------");

        //You can also do this by Lambda Expressions.
        students.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println(students);
        students.sort((s1, s2) -> s1.rollNumber - s2.rollNumber);
        System.out.println(students);
        students.sort((s1, s2) -> s1.marks - s2.marks);
        System.out.println(students);
        System.out.println("--------------------------------");

        //If you want to compare by multiple criteria
        students.sort(Comparator.comparing((Student s) -> s.rollNumber).thenComparing(s -> s.name));
        System.out.println(students);
    }
}
