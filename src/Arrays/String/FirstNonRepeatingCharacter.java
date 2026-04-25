package Arrays.String;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        String input = "aabb";

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
//            freqMap.merge(ch, 1, Integer::compareTo);
        }

        char result = '\0';

        for (char ch : input.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                result = ch;
                break;
            }
        }
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        System.out.println("First Non-Repeating Character: " + firstNonRepeatingChar(input));
    }

    public static char firstNonRepeatingChar(String input) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : input.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                return ch;
            }
        }
        return '\0';
    }


}
