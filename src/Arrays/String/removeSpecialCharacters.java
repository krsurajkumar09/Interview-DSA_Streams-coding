package Arrays.String;

public class removeSpecialCharacters {
        public static void main(String[] args) {
            String input = "he@llo!!";

            StringBuilder result = new StringBuilder();

            for (char ch : input.toCharArray()) {
                if (Character.isLetter(ch)) {
                    result.append(ch);
                }
            }

            System.out.println("Result: " + result);

//            Using regex
//            String input = "he@llo!!";
//            String result = input.replaceAll("[^a-zA-Z]", "");
//            System.out.println("Result: " + result);

              System.out.println("Result: " + removeSpecialCharacters(input));
        }

    public static String removeSpecialCharacters(String input) {

        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
