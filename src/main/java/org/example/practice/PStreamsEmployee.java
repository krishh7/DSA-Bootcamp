package org.example.practice;

import org.example.java8features.streams.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PStreamsEmployee {
    private int id;
    private String name;
    private int age;
    private String deptName;
    private String address;
    private double salary;
    private String gender;

    public PStreamsEmployee(int id, String name, int age, String deptName, String address, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.deptName = deptName;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", deptName='" + deptName + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<PStreamsEmployee> employees = Arrays.asList(
                new PStreamsEmployee(1, "Abraham", 29, "IT", "Mumbai", 20000, "Male"),
                new PStreamsEmployee(2, "Mary", 27, "Sales", "Chennai", 25000, "Female"),
                new PStreamsEmployee(3, "Joe", 28, "IT", "Chennai", 22000, "Male"),
                new PStreamsEmployee(4, "John", 29, "Sales", "Gurgaon", 29000, "Male"),
                new PStreamsEmployee(5, "Liza", 25, "Sales", "Bangalore", 32000, "Female"),
                new PStreamsEmployee(6, "Peter", 27, "Admin", "Mumbai", 31500, "Male"),
                new PStreamsEmployee(7, "Harry", 30, "Research", "Kochi", 21000, "Male")
        );

        //1. Find list of employees whose name starts with alphabet A
        List<PStreamsEmployee> employeesWithA = employees.stream().filter(e -> e.getName().startsWith("A")).collect(Collectors.toList());
        System.out.println("Employee name starts with A are: " + employeesWithA);

        //2. Group The employees By Department Names
        Map<String, List<PStreamsEmployee>> employeesGroupedByDept = employees.stream().collect(Collectors.groupingBy(PStreamsEmployee::getDeptName));
        System.out.println("Employees grouped by dept: " + employeesGroupedByDept);

        //3 Find the total count of employees using stream
        long employeeCount = employees.stream().count();
        System.out.println("Employees count: " + employeeCount);

        //4. Find the max age of employees
        Optional<PStreamsEmployee> maxAgeOfEmp = employees.stream().max(Comparator.comparing(PStreamsEmployee::getAge));
        System.out.println("Max Age of Employee " + maxAgeOfEmp);

        //5. Find all department names
        List<String> allDepts = employees.stream().map(PStreamsEmployee::getDeptName).collect(Collectors.toList());
        System.out.println("All Dept names: " + allDepts);

        //6. Find the count of employee in each department
        Map<String, Long> countOfEmpInEachDept = employees.stream().collect(Collectors.groupingBy(PStreamsEmployee::getDeptName, Collectors.counting()));
        System.out.println("Count of employees in each dept: " + countOfEmpInEachDept);

        //7. Find the list of employees whose age is less than 30
        List<PStreamsEmployee> employeesBelow30age = employees.stream().filter(e -> e.getAge() < 30).collect(Collectors.toList());
        System.out.println("Employees age below 30: " + employeesBelow30age);

        //8. Find the list of employees whose age is in between 26 and 31
        List<PStreamsEmployee> employeesAge26to30 = employees.stream().filter(e -> e.getAge() > 26 && e.getAge() < 30).collect(Collectors.toList());
        System.out.println("Employees age 26 to 30: " + employeesAge26to30);

        //9. Find the average age of male and female employee
        Map<String, Double> avgAgeOfMF = employees.stream().collect(Collectors.groupingBy(PStreamsEmployee::getGender, Collectors.averagingInt(PStreamsEmployee::getAge)));
        System.out.println("Average age of male and female: " + avgAgeOfMF);

        //10. Find the department who is having maximum number of employee
        Optional<Map.Entry<String, Long>> deptWithMaxEmployees = employees.stream().collect(Collectors.groupingBy(PStreamsEmployee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println("Dept with max number of employees: " + deptWithMaxEmployees);

        //11. Find the Employee who stays in Mumbai and sort them by their names
        List<PStreamsEmployee> sortedMumbaiEmps = employees.stream().filter(e -> e.getAddress().equals("Mumbai")).sorted(Comparator.comparing(PStreamsEmployee::getName)).collect(Collectors.toList());
        System.out.println("Sorted Mumbai Employees: " + sortedMumbaiEmps);

        //12. Find the average salary in all departments
        Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(PStreamsEmployee::getDeptName, Collectors.averagingDouble(PStreamsEmployee::getSalary)));
        System.out.println("Avg salary in all depts: " + collect);

        //13. Find the highest salary in each department
        Map<String, Optional<PStreamsEmployee>> highestSalInEachDept = employees.stream().collect(Collectors.groupingBy(PStreamsEmployee::getDeptName, Collectors.maxBy(Comparator.comparing(PStreamsEmployee::getSalary))));
        System.out.println("Highest Salary in each dept: " + highestSalInEachDept);

        //14. Find the list of employee and sort them by their salary
        List<PStreamsEmployee> employeesSortedBySalary = employees.stream().sorted(Comparator.comparing(PStreamsEmployee::getSalary)).collect(Collectors.toList());
        System.out.println("Employees sorted by Salary: " + employeesSortedBySalary);

        //15. Find the employee who has second-lowest salary
         Optional<PStreamsEmployee> secondLowestSalary = employees.stream().sorted(Comparator.comparing(PStreamsEmployee::getSalary)).skip(1).findFirst();
        System.out.println("Second lowest salary: " + secondLowestSalary);


        List<Integer> numbers = Arrays.asList(1, 3, 4, 4, 6, 6, 8, 15, 4, 9, 8, 98, 11, 12);

        //Squares of even numbers
        List<Integer> collect1 = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(collect1);

        //Squares of odd numbers
        List<Integer> collect2 = numbers.stream().filter(n -> n % 2 != 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(collect2);

        long count = numbers.stream().distinct().filter(num -> num > 5).count();
        System.out.println(count);

    }
}
