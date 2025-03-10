package com.example.demo.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamBeginnerQuestions {
    public static void main(String[] args) {
        
        // 1. Filtering Even Numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
        
        // 2. Convert List of Strings to Uppercase
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> upperCaseWords = words.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        System.out.println("Uppercase Words: " + upperCaseWords);
        
        // 3. Find the First Element that Starts with 'S'
        List<String> names = Arrays.asList("John", "Smith", "Sara", "Michael");
        Optional<String> firstSName = names.stream()
                                           .filter(name -> name.startsWith("S"))
                                           .findFirst();
        System.out.println("First name starting with 'S': " + firstSName.orElse("Not found"));
        
        // 4. Sum of All Elements
        Optional<Integer> sum = numbers.stream()
        		.reduce((num1, num2) -> num1 + num2);
        System.out.println("Sum of Numbers: " + sum.get());
        
        // 5. Count Words with Length > 3
        List<String> wordList = Arrays.asList("a", "the", "cat", "elephant", "dog");
        long count = wordList.stream()
                             .filter(word -> word.length() > 3)
                             .count();
        System.out.println("Count of Words with Length > 3: " + count);
        
        // 6. Sorting Numbers in Descending Order
        List<Integer> sortedDesc = numbers.stream()
                                          .sorted(Comparator.reverseOrder())
                                          .collect(Collectors.toList());
        System.out.println("Sorted Numbers (Descending): " + sortedDesc);
        
        // 7. Remove Duplicates from a List
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);
        List<Integer> uniqueNumbers = duplicateNumbers.stream()
                                                      .distinct()
                                                      .collect(Collectors.toList());
        System.out.println("Unique Numbers: " + uniqueNumbers);
        
        // 8. Convert List of Strings to a Single Comma-Separated String
        String joinedWords = words.stream()
                                  .collect(Collectors.joining(", "));
        System.out.println("Comma-Separated String: " + joinedWords);
        
        // 9. Find the Maximum Value
        Optional<Integer> maxNumber = numbers.stream()
                                             .max(Comparator.naturalOrder());
        System.out.println("Maximum Value: " + maxNumber.orElse(-1));
        
        // 10. Check if Any String Starts with 'A'
        List<String> nameList = Arrays.asList("Bob", "Alice", "Charlie", "Andrew");
        boolean anyStartsWithA = nameList.stream()
                                         .anyMatch(name -> name.startsWith("A"));
        System.out.println("Any name starts with 'A': " + anyStartsWithA);
    }
}
