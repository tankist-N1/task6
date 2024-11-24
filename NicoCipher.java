import java.util.Arrays;
import java.util.Comparator;

public class NicoCipher {
    public static String nicoCipher(String message, String key) {
        int keyLength = key.length();
        int rows = (int) Math.ceil((double) message.length() / keyLength);
        char[][] matrix = new char[rows][keyLength];

        for (int i = 0; i < message.length(); i++) {
            matrix[i / keyLength][i % keyLength] = message.charAt(i);
        }

        for (int i = message.length(); i < rows * keyLength; i++) {
            matrix[i / keyLength][i % keyLength] = ' ';
        }

        Integer[] order = new Integer[keyLength];
        for (int i = 0; i < keyLength; i++) {
            order[i] = i;
        }

        Arrays.sort(order, Comparator.comparingInt(key::charAt));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j : order) {
                result.append(matrix[i][j]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh")); // "yowmledrovlvsnieesrh"
        System.out.println(nicoCipher("andiloveherso", "tesha")); // "lnidaevheo s or"
        System.out.println(nicoCipher("mubashirhassan", "crazy")); // "bmusarhiahass n"
        System.out.println(nicoCipher("edabitisamazing", "matt")); // "deabtiismaaznig "
        System.out.println(nicoCipher("iloveher", "612345")); // "lovehir e"
    }
}