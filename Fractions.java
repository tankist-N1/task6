public class Fractions {
    public static String fractions(String decimal) {
        String[] parts = decimal.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts[1].split("\\(")[0];
        String repeatingPart = parts[1].split("\\(")[1].replace(")", "");

        @SuppressWarnings("unused")
        int integerValue = Integer.parseInt(integerPart);
        int decimalLength = decimalPart.length();
        int repeatingLength = repeatingPart.length();

        long numerator = Long.parseLong(integerPart + decimalPart + repeatingPart) - Long.parseLong(integerPart + decimalPart);
        long denominator = (long) Math.pow(10, decimalLength + repeatingLength) - (long) Math.pow(10, decimalLength);

        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(fractions("0.(6)")); // "2/3"
        System.out.println(fractions("1.(1)")); // "10/9"
        System.out.println(fractions("3.(142857)")); // "22/7"
        System.out.println(fractions("0.19(2367)")); // "5343/27775"
        System.out.println(fractions("0.1097(3)")); // "823/7500"
    }
}