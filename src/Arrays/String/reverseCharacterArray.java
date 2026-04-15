package Arrays.String;
import java.util.Arrays;

public class reverseCharacterArray {

    public static void main(String[] args) {

        char[] arr = {'H', 'E', 'L', 'L', 'O'};
        System.out.println("Original Char Array: " + Arrays.toString(arr));

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println("Reversed Char Array: " + Arrays.toString(arr));

//        reverseCharArray(arr);
//
//        System.out.println("Reversed Char Array: " + Arrays.toString(arr));
    }

    public static void reverseCharArray(char[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }


}
