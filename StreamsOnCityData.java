package com.example.demo.streams;

import java.util.*;
import java.util.stream.Collectors;


import java.util.*;
import java.util.stream.*;

class City {
    String name;
    int population;

    City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() { return name; }
    public int getPopulation() { return population; }

    @Override
    public String toString() {
        return name + "(" + population + ")";
    }
}

public class StreamsOnCityData {
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
            new City("Delhi", 12000),
            new City("Mumbai", 800000),
            new City("Bangalore", 450000),
            new City("Hyderabad", 1200000),
            new City("Chennai", 60000)
        );

        // 1. City with the second highest population
        Optional<City> secondHighest = cities.stream()
            .sorted(Comparator.comparingInt(City::getPopulation).reversed())
            .skip(1)
            .findFirst();
        System.out.println("Second Highest Population City: " + secondHighest.get());

        // 2. Group by first character of name, then max population in each group
        Map<Character, City> maxByInitial = cities.stream()
            .collect(Collectors.groupingBy(
                c -> c.getName().charAt(0),
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingInt(City::getPopulation)),
                    Optional::get
                )
            ));
        System.out.println("Max by Initial: " + maxByInitial);

        // 3. Average population of top 3 most populated cities
        double avgTop3 = cities.stream()
            .sorted(Comparator.comparingInt(City::getPopulation).reversed())
            .limit(3)
            .collect(Collectors.averagingInt(City::getPopulation));
        System.out.println("Average of Top 3 Cities: " + avgTop3);

        // 4. Map of population range -> city names
        Map<String, List<String>> byRange = cities.stream()
            .collect(Collectors.groupingBy(
                c -> {
                    int p = c.getPopulation();
                    if (p <= 100_000) return "0–100k";
                    else if (p <= 500_000) return "100k–500k";
                    else if (p <= 1_000_000) return "500k–1M";
                    else return "1M+";
                },
                Collectors.mapping(City::getName, Collectors.toList())
            ));
        System.out.println("Cities by Range: " + byRange);

        // 5. Using reduce: String of cities ordered by population
        // Expected output: Hyderabad(1200000) > Mumbai(800000) > Bangalore(450000) > Chennai(60000) > Delhi(12000)
        String populationChain = cities.stream()
            .sorted(Comparator.comparingInt(City::getPopulation).reversed())
            .map(c -> c.getName() + "(" + c.getPopulation() + ")")
            .reduce((a, b) -> a + " > " + b)
            .orElse("");
        System.out.println("Population Chain: " + populationChain);
    }
}

