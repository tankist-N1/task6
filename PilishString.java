public class PilishString {
    public static String pilish_string(String txt) {
        int[] piDigits = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int digit : piDigits) {
            if (index >= txt.length()) break;

            if (index + digit > txt.length()) {
                String lastWord = txt.substring(index);
                lastWord += lastWord.charAt(lastWord.length() - 1);
                result.append(lastWord).append(" ");
                break;
            }

            result.append(txt, index, index + digit).append(" ");
            index += digit;
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(pilish_string("33314444")); // "333 1 4444"
        System.out.println(pilish_string("TOP")); // "TOP"
        System.out.println(pilish_string("X")); // "XXX"
        System.out.println(pilish_string("")); // ""
    }
}