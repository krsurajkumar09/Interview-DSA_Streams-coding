package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamString {

    public static void main(String[] args) {
        List<String> list3 = Arrays.asList("Banana", "Apple", "Mango", "Orange");

        String longest = list3.stream()
                .max(Comparator.comparing(String::length))
                .orElse(null);

        System.out.println("Longest String: " + longest);

        String min = list3.stream()
                .max(Comparator.comparing(String::length))
                .orElse(null);

        System.out.println("Longest String: " + min);


        List<String> sorted3 = list3.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();


        List<String> list = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "kiwi"
        );

        // 🧪 1. Unique Elements (count == 1)
        List<String> unique = list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,   // preserves order
                        Collectors.counting()
                )).entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
                .toList();

        System.out.println("Unique Elements: " + unique);


        // a.Count the frequency of String input
        String str = "aabccd";

        Map<Character, Long> freqMapping = str.chars()   // IntStream
                .mapToObj(c -> (char) c)            // convert int → char
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(freqMapping);

        // b.Count the frequency of character array input
        char[] arr3 = {'a', 'a', 'b', 'c', 'c', 'd'};

        Map<Character, Long> freqMapping2 = new String(arr3)  // convert to String
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(freqMapping2);

        // Cleaning the string
        String[] input = {
                "aa",
                "b@##b",
                null,
                " ",
                "",
                " c c ",
                "654^^@#",
                "       ",
                "........................436abc668d9g...."
        };

        String cleanedInput = Arrays.stream(input)
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(s -> s.replaceAll("[^a-zA-Z]", ""))
                .collect(Collectors.joining());

        System.out.println("Cleaned Input is : " + cleanedInput);


        // ================================
        // PART 1 — map() Examples
        // ================================

        System.out.println("===== map() Examples =====");

        // Example 1: Uppercase conversion
        List<String> fruits = Arrays.asList("apple", "banana", "mango");

        List<String> upper = fruits.stream()
                .map(String::toUpperCase)
                .collect(toList());

        System.out.println("Uppercase: " + upper);


        // Example 2: Extract names from Employee
        List<Employee> employees = Arrays.asList(
                new Employee("Ram", "IT", 50000),
                new Employee("Shyam", "HR", 40000),
                new Employee("Mohan", "Finance", 60000)
        );

        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(toList());

        System.out.println("Employee Names: " + names);


        // Example 3: Convert String → Integer
        List<String> nums = Arrays.asList("1", "2", "3");

        List<Integer> numbers = nums.stream()
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println("Converted Numbers: " + numbers);


        // ================================
        // PART 2 — flatMap() Examples
        // ================================

        System.out.println("\n===== flatMap() Examples =====");

        // Example 1: Flatten list
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> flat = nestedList.stream()
                .flatMap(List::stream)
                .collect(toList());

        System.out.println("Flattened List: " + flat);


        // Example 2: Flatten + Uppercase
        List<List<String>> words = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("mango", "orange")
        );

        List<String> transformed = words.stream()
                .flatMap(List::stream)
                .map(String::toUpperCase)
                .collect(toList());

        System.out.println("Flatten + Uppercase: " + transformed);


        // Example 3: Split words into characters
        List<String> wordList = Arrays.asList("Java", "Stream");

        List<String> chars = wordList.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(toList());

        System.out.println("Characters: " + chars);


        String[] wordList2 = {"Java", "Stream"};

        Arrays.stream(wordList2)
                .flatMap(word -> Arrays.stream(word.split("")))
                .forEach(System.out::println);


    }


}
