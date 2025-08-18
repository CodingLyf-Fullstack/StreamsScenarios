package com.example.demo.streams;

import java.util.*;
import java.util.stream.*;

class Student {
    String firstName, lastName, city, department;
    double grade;
    int age;

    public Student(String firstName, String lastName, String city, double grade, int age, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.grade = grade;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + city + ", " + grade + ", " + age + ", " + department + ")";
    }
}

public class AdvancedStreams {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Rahul", "Sharma", "Hyderabad", 8.38, 19, "Civil"),
            new Student("Amit", "Verma", "Delhi", 8.4, 21, "IT"),
            new Student("Suresh", "Reddy", "Hyderabad", 7.5, 20, "Civil"),
            new Student("Kiran", "Patel", "Mumbai", 9.1, 20, "IT"),
            new Student("Arjun", "Naidu", "Bengaluru", 7.83, 20, "Civil")
        );

        // 1. Find students from Hyderabad with a grade greater than 8.0
        List<Student> HyderabadHighGrades = students.stream()
                .filter(s -> s.city.equals("Hyderabad") && s.grade > 8.0)
                .collect(Collectors.toList());
        System.out.println("1. Hyderabad students with grade > 8.0: " + HyderabadHighGrades);

        // 2. Find the student with the highest grade
        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingDouble(s -> s.grade));
        System.out.println("2. Student with the highest grade: " + topStudent.orElse(null));

        // 3. Count the number of students in each department
        Map<String, Long> departmentCount = students.stream()
                .collect(Collectors.groupingBy(s -> s.department, Collectors.counting()));
        System.out.println("3. Number of students per department: " + departmentCount);

        // 4. Find the average grade per department
        Map<String, Double> avgGradeByDept = students.stream()
                .collect(Collectors.groupingBy(s -> s.department, Collectors.averagingDouble(s -> s.grade)));
        System.out.println("4. Average grade per department: " + avgGradeByDept);

        // 5. List students sorted by age and then by grade
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt((Student s) -> s.age).thenComparingDouble(s -> s.grade))
                .collect(Collectors.toList());
        System.out.println("5. Students sorted by age, then grade: " + sortedStudents);

        // 6. Create a comma-separated list of student names
        String names = students.stream()
                .map(s -> s.firstName + " " + s.lastName)
                .collect(Collectors.joining(", "));
        System.out.println("6. Comma-separated student names: " + names);

        // 7. Check if all students are above 18
        boolean allAbove18 = students.stream().allMatch(s -> s.age > 18);
        System.out.println("7. Are all students above 18? " + allAbove18);

        // 8. Find the department with the most students
        String mostPopularDept = students.stream()
                .collect(Collectors.groupingBy(s -> s.department, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
        System.out.println("8. Department with most students: " + mostPopularDept);

        // 9. Divide students into those who have grades above 8.0 and below
        Map<Boolean, List<Student>> gradePartition = students.stream()
                .collect(Collectors.partitioningBy(s -> s.grade > 8.0));
        System.out.println("9. Students partitioned by grade: " + gradePartition);

        // 10. Find the student with the longest full name
        Optional<Student> longestNameStudent = students.stream()
                .max(Comparator.comparingInt(s -> (s.firstName + s.lastName).length()));
        System.out.println("10. Student with the longest full name: " + longestNameStudent.orElse(null));
    }
}
