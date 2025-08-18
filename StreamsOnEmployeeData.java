package com.sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

record EmployeeDto(
        String name,
        String department,
        int age,
        String gender
) { }

public class StreamsOnEmployeeData {
	public static void main(String[] args) {
		EmployeeDto employee1 = new EmployeeDto("SRK","ECE",31,"Male");
        EmployeeDto employee2 = new EmployeeDto("Salman","CS",44,"Male");
        EmployeeDto employee3 = new EmployeeDto("Katrina","ECE",21,"Female");
        EmployeeDto employee4 = new EmployeeDto("Kareena","CS",34,"Female");
        EmployeeDto employee5 = new EmployeeDto("Hrithik","EEE",30,"Male");
        EmployeeDto employee6 = new EmployeeDto("Aish","EEE",25,"Female");

        List<EmployeeDto> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
        
        
        // 1.Find the names of all EmployeeDtos in the CS department, sorted by age in descending order.
	        List<EmployeeDto> csSortedEmployeeDtos = list.stream()
	        	.filter(e -> e.department() == "CS")
				.sorted(Comparator.comparingInt(EmployeeDto::age)
				.reversed())
				.toList();
		System.out.println("CS Sorted Employees: " + csSortedEmployeeDtos);

		// 2.Group EmployeeDtos by department and count how many EmployeeDtos are in each department.
		Map<String, Long> departmentGroup = list.stream()
				.collect(Collectors.groupingBy(EmployeeDto::department, Collectors.counting()));
		System.out.println("Department wise count: " + departmentGroup);
		
		// 3.Find the youngest female EmployeeDto.
		String youngestFemaleName = list.stream()
		 .filter(e -> e.gender() == "Female")
		 .min(Comparator.comparingInt(EmployeeDto::age)).get().name();
		System.out.println("Youngest Female Name: "+youngestFemaleName);

		// 4. Create a map of department → list of EmployeeDto names.
		Map<String, List<String>> departmentMap = list.stream()
				.collect(Collectors.groupingBy(EmployeeDto::department, 
						 Collectors.mapping(EmployeeDto::name, Collectors.toList())));
		System.out.println("Department Map: " + departmentMap);
		
		//5. Find the average age of EmployeeDtos in each department.
		Map<String, Double> averageAgeForDepartment = list.stream()
			.collect(Collectors.groupingBy(EmployeeDto::department, Collectors.averagingInt(EmployeeDto::age)));
		System.out.println("Average Age by Department: " + averageAgeForDepartment);
        
		//6. Get a list of unique departments Employees belong to.
		HashSet<String> seen = new HashSet<>();
		List<String> uniqueDepartments =  list.stream()
				.filter(e -> seen.add(e.department()))
				.map(e -> e.department())
				.toList();
		System.out.println("Unique Departments: " + uniqueDepartments);

        // 7. Partition EmployeeDtos into male and female groups, then list their names.
		Map<String, List<String>> partitionedList =   list.stream().collect(Collectors.groupingBy(e -> {
			 if(e.gender() == "Female") {
				 return "Female";
			 }
			 else if(e.gender() == "Male") {
				 return "Male";
			 }
			 return "";
		 },
		 Collectors.mapping(e -> e.name(), Collectors.toList())
		));
		System.out.println("Partitioned List: " + partitionedList);

		
        //8. Group employees by department, then within each department find the oldest employee
		Map<String, Optional<EmployeeDto>> departmentWiseGroup = list
				.stream()
				.collect(Collectors.groupingBy(EmployeeDto::department,
						Collectors.maxBy(Comparator.comparingInt(EmployeeDto::age))));
		System.out.println("Department Wise Group List: " + departmentWiseGroup);
		
		//9. Build a map of gender with average age of employees sorted by average age descending
		Map<String, Double> mapOfGender = list
		.stream().collect(Collectors.groupingBy(EmployeeDto::gender, Collectors.averagingDouble(EmployeeDto::age)));
		System.out.println("Map of Gender: " + mapOfGender);
		
		//10. For each department, find the youngest employee,
		// but instead of returning the employee object, return only their name in uppercase.
		  Map<String, String> youngestByDept = list.stream()
		            .collect(Collectors.groupingBy(
		                EmployeeDto::department,
		                Collectors.collectingAndThen(
		                    Collectors.minBy(Comparator.comparingInt(EmployeeDto::age)),
		                    e -> e.get().name().toUpperCase()
		                )
		            ));

		  System.out.println("Youngest by Dept: " + youngestByDept);
	}
}