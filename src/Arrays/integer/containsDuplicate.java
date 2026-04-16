package Arrays.integer;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 5};

        Set<Integer> seen = new HashSet<>();

        boolean hasDuplicate = false;

        for (int num : arr) {
            if (!seen.add(num)) {
                hasDuplicate = true;
                break;
            }

        }

        System.out.println("Contains Duplicate: " + hasDuplicate);

//      System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] arr) {

        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
