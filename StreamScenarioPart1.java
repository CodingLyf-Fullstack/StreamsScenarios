package com.example.demo.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamScenarioPart1 {

	public static void main(String a[]) {
		List<Integer> numbers = List.of(1, 2, 7, 3, 4, 5, 2, 3, 6, 7, 8, 8);
		
		//Remove duplicates
		List<Integer> nonduplicateList = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println(nonduplicateList);
		
		
		
		//Find second highest salary
		List<Integer> salaries = List.of(3000,9000, 5000, 7000, 9000, 5000);
		Integer secondHighestInteger = salaries.stream()
												.distinct()  // [3000, 9000, 5000, 7000].
												.sorted(Comparator.reverseOrder()) //[9000, 7000, 5000, 3000].
												.skip(1) // [7000, 5000, 3000].
												.findFirst()
												.get();
		System.out.println(secondHighestInteger);
	}
}
