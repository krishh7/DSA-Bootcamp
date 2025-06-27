package org.example.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
        List<Student> studlist = Arrays.asList(
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
        List<Student> studentsNameStartsWithA = studlist.stream().filter(s -> s.firstName.startsWith("A")).collect(Collectors.toList());
        System.out.println(studentsNameStartsWithA);

        //3.Group Students by Department Name:
        Map<String, List<Student>> groupedByDept = studlist.stream().collect(Collectors.groupingBy(Student::getDeptName));
        System.out.println(groupedByDept);

        //4. Count the Total Number of Students:
        long totalNumberOfStudents = studlist.stream().count();
        System.out.println(totalNumberOfStudents);

        //5. Find the Maximum Age:
        OptionalInt maximunAge = studlist.stream().mapToInt(Student::getAge).max();
        System.out.println(maximunAge);

        //6. Find All Unique Department Names:
        List<String> uniqueDepts = studlist.stream().map(Student::getDeptName).distinct().collect(Collectors.toList());
        System.out.println(uniqueDepts);

        //7. Count Students in Each Department:
        Map<String, Long> studentsInEachDept = studlist.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.counting()));
        System.out.println(studentsInEachDept);

        //8. Find Students Below Age 30:
        List<Student> studentsUnder30 = studlist.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
        System.out.println(studentsUnder30);

        //9. Find Students with Rank Between 50 and 100:
        List<Student> studentsRanks50To100 = studlist.stream().filter(s -> s.getRank() < 100 && s.getRank() > 50).toList();
        System.out.println(studentsRanks50To100);

        //10. Average Age of Male and Female Students:
        Map<String, Double> avgAgeMF = studlist.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeMF);

        //11. Find Department with Maximum Number of Students:
        Map<String, Long> collect = studlist.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.counting()));
        Map.Entry<String, Long> maxStudentsOfDept = collect.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(maxStudentsOfDept);

        //12. Find Students in Karnataka and Sort by Name:
        List<Student> kaStudentsSorted = studlist.stream().filter(s -> s.city.equals("Karnataka")).sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
        System.out.println(kaStudentsSorted);

        //13. Average Rank in Each Department:
        Map<String, Double> avgRankInEachDept = studlist.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.averagingInt(Student::getRank)));
        System.out.println(avgRankInEachDept);

        //14. Find the Highest Rank (Lowest Value) in Each Department:
        Map<String, Optional<Student>> highestRank = studlist.stream().collect(Collectors.groupingBy(Student::getDeptName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(highestRank);

        //15. Sort Students by Rank:
        List<Student> studentsByRank = studlist.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
        System.out.println(studentsByRank);

        //16. Find the Student with the Second-Highest Rank:
        Optional<Student> secondHighestRank = studlist.stream().sorted(Comparator.comparing(Student::getRank)).distinct().skip(1).findFirst();
        System.out.println(secondHighestRank);

    }
}
