package Arrays.integer;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

public class removeDuplicates {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5};

//        Set<Integer> uniqueSet = new LinkedHashSet<>();
//
//        for (int num : arr) {
//            uniqueSet.add(num);
//        }
//
//        System.out.println(uniqueSet);


//        Set<Integer> result = removeDuplicates(arr);
//
//        System.out.println(result);


        System.out.println(Arrays.toString(removeDuplicatesReturnArray(arr)));
    }

    public static Set<Integer> removeDuplicates(int[] arr) {

        Set<Integer> uniqueSet = new LinkedHashSet<>();

        for (int num : arr) {
            uniqueSet.add(num);
        }

        return uniqueSet;
    }

//    return array instead of set
    public static int[] removeDuplicatesReturnArray(int[] arr) {

        Set<Integer> uniqueSet = new LinkedHashSet<>();

        for (int num : arr) {
            uniqueSet.add(num);
        }

        int[] result = new int[uniqueSet.size()];
        int index = 0;

        for (int num : uniqueSet) {
            result[index++] = num;
        }

        return result;
    }

}
