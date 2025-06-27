package org.example.java8features.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String deptName;
    private String address;
    private double salary;
    private String gender;

    public Employee(int id, String name, int age, String deptName, String address, double salary, String gender) {
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
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Abraham", 29, "IT", "Mumbai", 20000, "Male"),
                new Employee(2, "Mary", 27, "Sales", "Chennai", 25000, "Female"),
                new Employee(3, "Joe", 28, "IT", "Chennai", 22000, "Male"),
                new Employee(4, "John", 29, "Sales", "Gurgaon", 29000, "Male"),
                new Employee(5, "Liza", 25, "Sales", "Bangalore", 32000, "Female"),
                new Employee(6, "Peter", 27, "Admin", "Mumbai", 31500, "Male"),
                new Employee(7, "Harry", 30, "Research", "Kochi", 21000, "Male")
        );

        //1. Find list of employees whose name starts with alphabet A
        List<Employee> employeesNameWithA = employees.stream().filter(e -> e.getName().startsWith("A")).collect(Collectors.toList());
        System.out.println(employeesNameWithA);

        //2. Group The employees By Department Names
        Map<String, List<Employee>> employeesByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName));
        System.out.println(employeesByDept);

        //3 Find the total count of employees using stream
        long countOfEmployees = employees.stream().count();
        System.out.println(countOfEmployees);

        //4. Find the max age of employees
        Optional<Employee> maxAge = employees.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println(maxAge);

        //5. Find all department names
        List<String> allDept = employees.stream().map(Employee::getDeptName).collect(Collectors.toList());
        System.out.println(allDept);

        //6. Find the count of employee in each department
        Map<String, Long> countOfEmployeesInEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println(countOfEmployeesInEachDept);

        //7. Find the list of employees whose age is less than 30
        List<Employee> employeesUnder30 = employees.stream().filter(e -> e.getAge() < 30).collect(Collectors.toList());
        System.out.println(employeesUnder30);

        //8. Find the list of employees whose age is in between 26 and 31
        List<Employee> employeesBW26To31 = employees.stream().filter(e -> e.getAge() >= 26 && e.getAge() <= 31).collect(Collectors.toList());
        System.out.println(employeesBW26To31);

        //9. Find the average age of male and female employee
        Map<String, Double> avgAgeFM = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeFM);

        //10. Find the department who is having maximum number of employee
        Map.Entry<String, Long> deptHavingMaxAgeOfAnEmp = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(deptHavingMaxAgeOfAnEmp);

        //11. Find the Employee who stays in Mumbai and sort them by their names
        List<Employee> mumbaiEmployees = employees.stream().filter(e -> e.getAddress().equals("Mumbai")).sorted(Comparator.comparing(Employee::getName)).toList();
        System.out.println(mumbaiEmployees);

        //12. Find the average salary in all departments
        Map<String, Double> avgSalariesInAllDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalariesInAllDept);

        //13. Find the highest salary in each department
        Map<String, Optional<Employee>> maxSalaryInEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(maxSalaryInEachDept);

        //14. Find the list of employee and sort them by their salary
        List<Double> employeesSortedBySalary = employees.stream().map(Employee::getSalary).sorted().toList();
        System.out.println(employeesSortedBySalary);

        //15. Find the employee who has second-lowest salary
        Optional<Employee> secondLowestSalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst();
        System.out.println(secondLowestSalary);

    }
}
