package Arrays.String;

public class FormatString {

    public static void main(String[] args) {

        String input = "  hello^%  world 123";



        String[] words = input.replaceAll("[^a-zA-Z ]", "")
                .trim()
                .split("\\s+");

        StringBuilder result = new StringBuilder("#");

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());

                // If Space is required between words
//                if (i < words.length - 1) {
//                    result.append(" ");
//                }
            }
        }

        System.out.println(result);

//        System.out.println(formatString(input));
    }

    public static String formatString(String input) {

        String[] words = input.replaceAll("[^a-zA-Z ]", "")
                .trim()
                .split("\\s+");

        StringBuilder result = new StringBuilder("#");

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());

                // If Space is required between words
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }
}
