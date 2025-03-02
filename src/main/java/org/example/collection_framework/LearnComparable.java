package org.example.collection_framework;

import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person> {
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    Double gpa;

    public Person(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(o.gpa, this.gpa);
    }
}
public class LearnComparable {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Karthik", 7.8));
        persons.add(new Person("Vinod", 7.5));
        persons.add(new Person("Reddy", 8.5));
        persons.add(new Person("Vikram", 9.5));
        persons.sort(null);
        System.out.println(persons);
    }
}
