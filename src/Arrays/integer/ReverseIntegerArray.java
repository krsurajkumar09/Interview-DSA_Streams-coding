package Arrays.integer;
import java.util.Arrays;

public class ReverseIntegerArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original Array : "+ Arrays.toString(arr));

//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left < right) {
//            int temp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = temp;
//
//            left++;
//            right--;
//        }

//      System.out.println("Reversed Array : "+ Arrays.toString(arr));
////      Printing with void reverseArray method
//        reverseArray(arr);
//        System.out.println(Arrays.toString(arr));


        // Printing with returning new reversed array
        int [] reversed = returnReversedArray(arr);
        System.out.println(Arrays.toString(reversed));
    }

    // Not retuning any array , just mutating/changing the existing array
    public static void reverseArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    //Returning new reversed array
    public static int[] returnReversedArray(int[] arr) {

        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

}
