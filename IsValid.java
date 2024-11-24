import java.util.HashMap;
import java.util.Map;

public class IsValid {
    public static String isValid(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int count : frequencyMap.values()) {
            countMap.put(count, countMap.getOrDefault(count, 0) + 1);
        }

        if (countMap.size() == 1) {
            return "YES";
        } else if (countMap.size() == 2) {
            int key1 = (int) countMap.keySet().toArray()[0];
            int key2 = (int) countMap.keySet().toArray()[1];
            int value1 = countMap.get(key1);
            int value2 = countMap.get(key2);

            if ((value1 == 1 && (key1 - 1 == key2 || key1 == 1)) || (value2 == 1 && (key2 - 1 == key1 || key2 == 1))) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbcd")); // "NO"
        System.out.println(isValid("aabbccddeefghi")); // "NO"
        System.out.println(isValid("abcdefghhgfedecba")); // "YES"
    }
}