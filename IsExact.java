public class IsExact {
    public static int[] isExact(int n) {
        return isExactHelper(n, 1, 1);
    }

    private static int[] isExactHelper(int n, int current, int factorial) {
        if (factorial == n) {
            return new int[]{n, current - 1};
        } else if (factorial > n) {
            return new int[]{};
        } else {
            return isExactHelper(n, current + 1, factorial * current);
        }
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(isExact(6))); // [6, 3]
        System.out.println(java.util.Arrays.toString(isExact(24))); // [24, 4]
        System.out.println(java.util.Arrays.toString(isExact(125))); // []
        System.out.println(java.util.Arrays.toString(isExact(720))); // [720, 6]
        System.out.println(java.util.Arrays.toString(isExact(1024))); // []
        System.out.println(java.util.Arrays.toString(isExact(40320))); // [40320, 8]
    }
}