public class PalindromeDescendant {
    public static boolean palindromeDescendant(int num) {
        String str = String.valueOf(num);
        while (str.length() > 1) {
            if (isPalindrome(str)) {
                return true;
            }
            str = getDescendant(str);
        }
        return false;
    }

    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private static String getDescendant(String str) {
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            descendant.append(sum);
        }
        return descendant.toString();
    }

    public static void main(String[] args) {
        System.out.println(palindromeDescendant(11211230)); // true
        System.out.println(palindromeDescendant(13001120)); // true
        System.out.println(palindromeDescendant(23336014)); // true
        System.out.println(palindromeDescendant(11)); // true
    }
}