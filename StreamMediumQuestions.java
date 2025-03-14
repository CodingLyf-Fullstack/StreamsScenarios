package com.example.demo.streams;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMediumQuestions {
    public static void main(String[] args) {
        
        // 1. Find the Second-Highest Number
        // Steps: Remove duplicates -> Sort in descending order -> Skip the highest -> Get the second-highest
        List<Integer> numbers = Arrays.asList(10, 20, 5, 8, 30, 25, 30);
        Integer secondHighest = numbers.stream()
                                       .distinct() // Removes duplicate elements
                                       .sorted(Comparator.reverseOrder()) // Sorts elements in descending order
                                       .skip(1) // Skips the first (highest) element
                                       .findFirst() // Retrieves the first element after skipping
                                       .orElse(null); // Returns null if no element found
        System.out.println("Second Highest Number: " + secondHighest);
        
        // 2. Count Occurrences of Each Word
        // Steps: Group words -> Count occurrences
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> wordCount = words.stream()
                                           .collect(Collectors.groupingBy(Function.identity(), // Groups elements by value
                                                                          Collectors.counting())); // Counts occurrences
        System.out.println("Word Count: " + wordCount);
        
        // 3. Remove Null and Empty Values
        // Steps: Remove null values -> Remove empty strings
        List<String> values = Arrays.asList("Hello", "", null, "World", "Java", "");
        List<String> filteredValues = values.stream()
                                            .filter(Objects::nonNull) // Filters out null values
                                            .filter(s -> !s.isEmpty()) // Filters out empty strings
                                            .collect(Collectors.toList()); // Collects the remaining values into a list
        System.out.println("Filtered Values: " + filteredValues);
        
        // 4. Find the Longest Word
        // Steps: Compare word lengths -> Get the longest
        String longestWord = words.stream()
                                  .max(Comparator.comparingInt(String::length)) // Finds the max element based on string length
                                  .orElse(null); // Returns null if no element found
        System.out.println("Longest Word: " + longestWord);
        
        // 5. Convert List of Objects to a Map
        // Steps: Convert List<Employee> to Map<Id, Name>
        List<Employee> employees = Arrays.asList(new Employee(1, "John"), new Employee(2, "Jane"));
        Map<Integer, String> employeeMap = employees.stream()
                                                    .collect(Collectors.toMap(Employee::getId, // Key: Employee ID
                                                                             Employee::getName)); // Value: Employee Name
        System.out.println("Employee Map: " + employeeMap);
        
        // 6. Flatten a List of Lists into a Single List
        // Steps: Flatten nested lists into a single list
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        List<Integer> flatList = nestedList.stream()
                                           .flatMap(List::stream) // Flattens the nested lists into a single stream
                                           .collect(Collectors.toList()); // Collects the result into a list
        System.out.println("Flattened List: " + flatList);
        
        // 7. Find First Non-Repeating Character in a String
        // Steps: Convert to stream -> Count occurrences -> Find the first unique character
        String input = "aabbcdeffg";
        Character firstNonRepeating = input.chars()
                                           .mapToObj(c -> (char) c) // Converts int stream to Character stream
                                           .collect(Collectors.groupingBy(Function.identity(), // Groups by character
                                                                          LinkedHashMap::new, 
                                                                          Collectors.counting())) // Counts occurrences
                                           .entrySet().stream()
                                           .filter(entry -> entry.getValue() == 1) // Filters characters occurring only once
                                           .map(Map.Entry::getKey) // Extracts the character
                                           .findFirst() // Finds the first match
                                           .orElse(null); // Returns null if no match found
        System.out.println("First Non-Repeating Character: " + firstNonRepeating);
        
        // 8. Group Numbers into Even and Odd
        // Steps: Partition numbers into even and odd groups
        Map<Boolean, List<Integer>> evenOddGrouping = numbers.stream()
                                                             .collect(Collectors.partitioningBy(n -> n % 2 == 0)); 
                                                             // Partitions numbers into true (even) & false (odd) lists
        System.out.println("Even & Odd Grouping: " + evenOddGrouping);
        
        // 9. Sort Strings by Length
        // Steps: Sort words based on length
        List<String> sortedByLength = words.stream()
                                           .sorted(Comparator.comparingInt(String::length)) // Sorts by string length
                                           .collect(Collectors.toList()); // Collects result into a list
        System.out.println("Sorted by Length: " + sortedByLength);
        
        // 10. Find the Most Repeated Number
        // Steps: Count occurrences -> Get the most repeated number
        Integer mostRepeated = numbers.stream()
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) 
                                      // Groups numbers and counts occurrences
                                      .entrySet().stream()
                                      .max(Map.Entry.comparingByValue()) // Finds entry with the highest count
                                      .map(Map.Entry::getKey) // Extracts the number from the entry
                                      .orElse(null); // Returns null if no match found
        System.out.println("Most Repeated Number: " + mostRepeated);
    }
}

class Employee {
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
}
