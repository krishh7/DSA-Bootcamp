package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class day1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Krishna", "Charan", "chiki", "ankitha", "Abhi", "Arun"));
        System.out.println(startsWithAandC(names));

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Vishal", 1, "EAIS", 25000));
        employeeList.add(new Employee("Ajay", 2, "CIS", 20000));
        employeeList.add(new Employee("Akhil", 3, "FS", 26000));
        employeeList.add(new Employee("Shiva", 4, "ADM", 28000));
        employeeList.add(new Employee("Manoj", 5, "ML", 22000));
        Map<String, List<Employee>> stringListMap = groupByEmpDept(employeeList);
        System.out.println(stringListMap);

        System.out.println(countOfEmployees(employeeList));

        //Count of Employees started with a
        int countOfEmployeesStartsWithA = employeeList.stream()
                .filter(emp -> emp.getName().toLowerCase().startsWith("a"))
                .mapToInt(emp -> 1)
                .sum();
        System.out.println(countOfEmployeesStartsWithA);

    }

    //Find list of employees whose name starts with alphabet A
    private static ArrayList<String> startsWithAandC(ArrayList<String> names) {
        return names
                .stream()
                .filter(name -> name.toLowerCase().startsWith("a")
                        || name.toLowerCase().startsWith("c"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //Group The employees By Department Names
    private static Map<String, List<Employee>> groupByEmpDept(ArrayList<Employee> employeeList) {

        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        return collect;
    }

    //total Count of employees
    private static long countOfEmployees(List<Employee> employeeList) {
        long count = employeeList.stream().count();
        return count;
    }
}
