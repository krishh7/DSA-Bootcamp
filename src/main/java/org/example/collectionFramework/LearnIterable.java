package org.example.collectionFramework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int rollNumber;
    int marks;

    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", marks=" + marks +
                '}';
    }
}

class NameComparator<Student> implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
public class LearnIterable {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("aa", 1, 78),
                new Student("bb", 4, 88),
                new Student("dd", 3, 92),
                new Student("cc", 2, 98)
        );

        List<String> names = Arrays.asList("KKK", "ZZZ", "LLL", "MMM");
        Collections.sort(names);
        System.out.println(names);

//        students.sort(new NameComparator<>());
//        students.sort((s1, s2) -> s1.name.compareTo(s2.name));
//        students.sort(Comparator.comparing(s -> s.name));
        students.sort((s1, s2) -> s1.marks - s2.marks);
//        students.sort(Comparator.comparingInt(s -> s.marks));
        System.out.println(students);
        Student student = new Student();
        System.out.println(student);
    }
}
