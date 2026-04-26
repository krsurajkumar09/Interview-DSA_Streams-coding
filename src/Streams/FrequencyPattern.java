package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyPattern {
    public static void main(String[] args) {

        // a.Count the frequency of String input
        String str = "aabccd";

        Map<Character, Long> freqMapping = str.chars()   // IntStream
                .mapToObj(c -> (char) c)            // convert int → char
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("Frequency of Each Characters are : "+freqMapping);

        // First non-repeating character
        String str4 = "character";

        Character result = str4.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First Non-repeating Character is: "+ result);

        char[] arr = {'c','h','a','r','a','c','t','e','r'};

        Character res = new String(arr)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First Non- repeating of Character array: "+res);

//    ********************   Array******************************************************************

        List<String> list = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "kiwi"
        );

        // First non-repeating element
        String firstNonRepeating = list.stream()
                .collect(Collectors.groupingBy(
                        n -> n,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(firstNonRepeating);


        String[] stri = {
                "apple", "banana", "apple", "orange", "banana", "kiwi"  } ;

        String result11 = Arrays.stream(stri)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result11);



//      2. On Number
        List<Integer> numbers = Arrays.asList(10,10,34,45,10,9,9,10);

        Integer secondLowest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElseThrow();

        long count = numbers.stream()
                .filter(n -> n.equals(secondLowest))
                .count();

        System.out.println("2nd Lowest Number: " + secondLowest);
        System.out.println("Occurrence: " + count);

        //2nd Way to solve it
        Map.Entry<Integer, Long> result5 =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .skip(1)
                        .findFirst()
                        .orElseThrow();

        System.out.println(result5.getKey());    // 10
        System.out.println(result5.getValue());  // 4



//       2nd Highest and his occurrence
        Integer secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();

        long secondHighestcounter = numbers.stream()
                .filter(n -> n.equals(secondHighest))
                .count();

        System.out.println("2nd Highest Number: " + secondHighest);
        System.out.println("Occurrence: " + secondHighestcounter);


        Map.Entry<Integer, Long> result98 =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                        .skip(1)
                        .findFirst()
                        .orElseThrow();

        System.out.println(result98.getKey());    // 34
        System.out.println(result98.getValue());  // 1

    }
}
