package Arrays.String;

public class Palindrome {

    public static void main(String[] args) {

        String input = "A man, a plan, a canal: Panama";

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        boolean isPalindrome = true;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }
        System.out.println("Is Palindrome: " + isPalindrome);
        System.out.println(isPalindrome(input));

    }

    public static boolean isPalindrome(String input) {

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


}
