package Arrays.String;

public class RemoveExtraSpaces {

    public static void main(String[] args) {

        String input = "   hello    world   java   ";

        String result = input.trim().replaceAll("\\s+", " ");

        System.out.println("Result: " + result);



//        String[] words = input.trim().split("\\s+");
//        String result = String.join(" ", words);
//        System.out.println(result);



//        — Without Regex
//        StringBuilder result = new StringBuilder();
//
//        int i = 0;
//        int n = input.length();
//
//        // Skip leading spaces
//        while (i < n && input.charAt(i) == ' ') {
//            i++;
//        }
//
//        while (i < n) {
//
//            if (input.charAt(i) != ' ') {
//                result.append(input.charAt(i));
//            } else {
//
//                // Add only one space between words
//                if (result.length() > 0 && result.charAt(result.length() - 1) != ' ') {
//                    result.append(' ');
//                }
//            }
//
//            i++;
//        }
//
//        // Remove trailing space if exists
//        if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
//            result.deleteCharAt(result.length() - 1);
//        }
//
//        System.out.println("Result: " + result.toString());
    }

    public static String removeExtraSpaces(String input) {

        return input.trim().replaceAll("\\s+", " ");
    }
}
