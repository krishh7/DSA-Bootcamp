package org.example.java8features.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String deptName;
    private int yearOfJoining;
    private String city;
    private int rank;

    public Student(int id, String firstName, String lastName, int age, String gender, String deptName, int yearOfJoining, String city, int rank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.deptName = deptName;
        this.yearOfJoining = yearOfJoining;
        this.city = city;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public String getCity() {
        return city;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", city='" + city + '\'' +
                ", rank=" + rank +
                '}';
    }

    public static void main(String[] args) {

        //1. Creating a List of Students:
        List<Student> studentsList = Arrays.asList(
                new Student(1, "Rohit", "Kumar",    30, "Male",  "Mechanical Engineering",      2015, "Mumbai",    122),
                new Student(2, "Pulkit","Singh",   56, "Male",  "Computer Engineering",        2018, "Delhi",     67),
                new Student(3, "Ankit", "Patil",   25, "Female","Mechanical Engineering",      2019, "Kerala",    164),
                new Student(4, "Satish","Malag",   30, "Male",  "Mechanical Engineering",      2014, "Kerala",    26),
                new Student(5, "Roshan", "Mukd",   23, "Male",  "Biotech Engineering",         2022, "Mumbai",    12),
                new Student(6, "Chetan", "Star",   24, "Male",  "Mechanical Engineering",      2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal",   26, "Male",  "Electronics Engineering",     2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev",       31, "Male",  "Computer Engineering",        2014, "Karnataka", 433),
                new Student(9, "Sonu","Shankar",   27, "Female","Computer Engineering",        2018, "Karnataka", 7),
                new Student(10,"Shubham","Pandey", 26, "Male",  "Instrumentation Engineering", 2017, "Mumbai",    98)
        );

        //2. Find Students Whose First Name Starts with 'A':
        List<Student> studentsNameStartsWithA = studentsList.stream().filter(s -> s.firstName.startsWith("A")).collect(Collectors.toList());
        System.out.println(studentsNameStartsWithA);

        //3.Group Students by Department Name:
        Map<String, List<Student>> studentsByDept = studentsList.stream().collect(Collectors.groupingBy(Student::getDeptName));
        System.out.println(studentsByDept);

        //4. Count the Total Number of Students:
        long totalStudents = studentsList.stream().count();
        System.out.println(totalStudents);

        //5. Find the Maximum Age: X
        OptionalInt maxAge = studentsList.stream().mapToInt(Student::getAge).max();
        System.out.println(maxAge);

        //6. Find All Unique Department Names:
        Map<String, List<Student>> uniqueDepts = studentsList.stream().collect(Collectors.groupingBy(Student::getDeptName));
        System.out.println(uniqueDepts);

        //7. Count Students in Each Department:
        Map<String, Long> studentsInEachDept = studentsList.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.counting()));
        System.out.println(studentsInEachDept);

        //8. Find Students Below Age 30:
        List<Student> studentsUnder30 = studentsList.stream().filter(s -> s.age < 30).toList();
        System.out.println(studentsUnder30);


        //9. Find Students with Rank Between 50 and 100:
        List<Student> studentsWithRank50To100 = studentsList.stream().filter(s -> s.getRank() >= 50 && s.getRank() <= 100).toList();
        System.out.println(studentsWithRank50To100);

        //10. Average Age of Male and Female Students:
        Map<String, Double> avgAgeMF = studentsList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeMF);

        //11. Find Department with Maximum Number of Students: X
        Map.Entry<String, Long> deptWithMaxStudents = studentsList.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(deptWithMaxStudents);

        //12. Find Students in Karnataka and Sort by Name:
        List<Student> sortedStudentsInKA = studentsList.stream().filter(s -> s.getCity().equals("Karnataka")).sorted(Comparator.comparing(Student::getFirstName)).toList();
        System.out.println(sortedStudentsInKA);

        //13. Average Rank in Each Department:
        Map<String, Double> avgRankEachDept = studentsList.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.averagingInt(Student::getRank)));
        System.out.println(avgRankEachDept);

        //14. Find the Highest Rank (Lowest Value) in Each Department:
        Map<String, Optional<Student>> highestRankByDept = studentsList.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println("highestRankByDept" + highestRankByDept);

        //15. Sort Students by Rank: X
        List<Student> sorted = studentsList.stream().sorted(Comparator.comparing(Student::getRank)).toList();
        System.out.println(sorted);

        //16. Find the Student with the Second-Highest Rank:
        Optional<Student> secondHighestRank = studentsList.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst();
        System.out.println(secondHighestRank);

    }
}
