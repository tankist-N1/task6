import java.util.HashMap;
import java.util.Map;

public class TwoProduct {
    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0) {
                int complement = n / arr[i];
                if (map.containsKey(complement) && map.get(complement) < i) {
                    return new int[]{complement, arr[i]};
                }
                map.put(arr[i], i);
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45))); // [9, 5]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45))); // [3, 15]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20))); // [4, 5]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10))); // [2, 5]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15))); // []
    }
}