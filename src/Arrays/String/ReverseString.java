package Arrays.String;

public class ReverseString {

    public static void main (String[] args){

        String input = "ABCDEFGH";
        char[] charArray = input.toCharArray();

        int leftIndex = 0;
        int rightIndex = input.length() -1;

        while(leftIndex < rightIndex){
            char temp = charArray[rightIndex];
            charArray[rightIndex] = charArray[leftIndex];
            charArray[leftIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
        System.out.println("Original string is " + input);
        System.out.println("Reversed string is " + new String(charArray));

        System.out.println("Reversed string is " + reverseString(input) );

    }

    public static String reverseString(String input){

        char[] charArray = input.toCharArray();

        int leftIndex =0;
        int rightIndex = charArray.length -1;

        while(leftIndex < rightIndex) {
            char temp = charArray[leftIndex];
            charArray[leftIndex] = charArray[rightIndex];
            charArray[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return new String (charArray);
    }
}
