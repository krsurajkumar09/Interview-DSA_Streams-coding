package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class intStream {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};

        int sumofEven = Arrays.stream(nums).filter(n -> n % 2 == 0)
                .sum();
        int minNum = Arrays.stream(nums).min().getAsInt();

        double average = Arrays.stream(nums).average().getAsDouble();

        long count = Arrays.stream(nums).skip(2).count();

        int[] sorted = Arrays.stream(nums).sorted().toArray();

        int[] sortedDesc = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

//        System.out.println(Arrays.toString(sortedDesc));

        int[] top2 = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .limit(2)
                .toArray();
//        System.out.println(Arrays.toString(top2));

//        System.out.println(sortedDesc);

        List<Integer> list = Arrays.asList(1, 2, 2, 5, 3);

        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int max = list.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        long count2 = list.stream().count();

        long c = list.size();


        List<Integer> sortedAsc = list.stream().sorted().toList();

        List<Integer> sortedDesc2 = list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        List<Integer> distinctSorted = list.stream()
                .distinct()
                .sorted()
                .toList();

        int secondHighest = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        List<Integer> doubleOfVEven = list.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*2)
                .toList();

        List<Integer> top2Number = list.stream()
                        .sorted(Comparator.reverseOrder())
                                .limit(2)
                                        .toList();


        System.out.println("List :" + top2Number);

    }
}
