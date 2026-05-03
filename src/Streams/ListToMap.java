package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Student> StudentList = new ArrayList<>();

        StudentList.add(new Student(1, "Ram"));
        StudentList.add(new Student(1, "Shyam"));
        StudentList.add(new Student(3, "Mugesh"));
        StudentList.add(new Student(2, "Ramesh"));

        //Convert the List into Map of unique only id and Name
        Map<Integer, String> studentMap = StudentList.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        Student::getName,
                        (oldValue, newValue) -> oldValue,
                        TreeMap::new  //if we want sorted on the basis of keys
//                      LinkedHashMap::new  //if we want to maintain the
//                      insertion order
                ));
        // 🔥 Print
//        studentMap.forEach(
//                (x, y) -> System.out.println("Student ID : " + x + ", Student Name : " + y)
//        );


        List<Employee> employees = Arrays.asList(
                new Employee("Suraj", "IT", 50000),
                new Employee("Amit", "IT", 30000),
                new Employee("Neha", "IT", 70000),
                new Employee("Ravi", "HR", 40000),
                new Employee("Abdul", "Sales", 30000),
                new Employee("Priya", "HR", 80000),
                new Employee("Karan", "HR", 60000),
                new Employee("John", "IT", 45000),
                new Employee("Yousuf", "IT", 30000),
                new Employee("Doe", "Sales", 80000)
        );

        // Partition employees based on salary > 50k
        Map<Boolean, List<Employee>> empPartition = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000));

//        System.out.println("Employee Partition (>50k): " + empPartition);
//
//        empPartition.forEach((key, value) -> {
//            System.out.println("Is salary > 50K: " + key + ",  Employees are: " + value );
//        });

//      Highest Salary Employee per Department:
//        System.out.println("\n3a. Highest Salary Employee per Department:");
        Map<String, Optional<Employee>> highestEmp = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

//        highestEmp.forEach((dept, emp) -> {
//            System.out.println(dept + " -> " + emp.get());
//        });

//        List<Map.Entry<String, Optional<Employee>>> list5 = highestEmp
//                .entrySet()
//                .stream()
//                .toList();
//        System.out.println(list5);

//      Lowest Salary Employee per Department:
        Map<String, Optional<Employee>> lowestEarningEmp = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.minBy(Comparator.comparing(Employee::getSalary))
                ));
//        lowestEarningEmp.forEach((dept, emp) -> {
//            System.out.println("Deptarmemt -> " + dept + "   Lowest earning Employee details : " + emp.get());
//        });

        // 4. Top 2 salaried employees per department
//        System.out.println("\n4. Top 2 Salaried Employees per Department:");
        Map<String, List<Employee>> top2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .limit(2)
                                        .collect(Collectors.toList())
                        )));

//        top2.forEach((dept, empList) -> {
//            System.out.println(dept + " -> " + empList);
//        });

        // 4. Top 2 less salaried employees per department

//      System.out.println("\n4.2 Minimum Salaried Employees per Department:");

        Map<String, List<Employee>> bottom2 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary))
                                        .limit(2)
                                        .toList()


                        )));

//        bottom2.forEach((dept, emp) ->{
//            System.out.println("Dept ->  "+dept + "     2 Lowest Earning employees are " +emp);
//        });

        System.out.println("Find the 2nd most highest earning employee in each department");
        Map<String, Optional<Employee>> secondHighestEarnerByDepartment =
                employees.stream().collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                                .skip(1)
                                                .findFirst()

                                ))
                );

        secondHighestEarnerByDepartment.forEach((dept, emp)-> {
            System.out.println(dept +"-> " + emp.get());
        });

    }
}
