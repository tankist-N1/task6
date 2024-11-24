import java.util.HashMap;
import java.util.Map;

public class HiddenAnagram {
    public static String hiddenAnagram(String sentence, String anagram) {
        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");
        anagram = anagram.toLowerCase().replaceAll("[^a-z]", "");

        for (int i = 0; i <= sentence.length() - anagram.length(); i++) {
            String substring = sentence.substring(i, i + anagram.length());
            if (isAnagram(substring, anagram)) {
                return substring;
            }
        }

        return "noutfond";
    }

    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived")); // "worldevolvesin"
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood")); // "noldwestactio"
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison")); // "mrmojorisin"
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM")); // "anamarg"
        System.out.println(hiddenAnagram("D e b90it->?$ (c)a r...d,,#~", "bad credit")); // "debitcard"
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth")); // "noutfond"
    }
}