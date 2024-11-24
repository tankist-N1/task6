import java.util.HashMap;
import java.util.Map;

public class StripUrlParams {
    public static String stripUrlParams(String url, String... paramsToStrip) {
        if (!url.contains("?")) return url;

        String[] parts = url.split("\\?");
        String baseUrl = parts[0];
        String queryString = parts[1];

        Map<String, String> params = new HashMap<>();
        for (String param : queryString.split("&")) {
            String[] keyValue = param.split("=");
            params.put(keyValue[0], keyValue[1]);
        }

        if (paramsToStrip.length > 0) {
            for (String param : paramsToStrip) {
                params.remove(param);
            }
        }

        StringBuilder result = new StringBuilder(baseUrl + "?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2")); // "https://edabit.com?a=2&b=2"
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", "b")); // "https://edabit.com?a=2"
        System.out.println(stripUrlParams("https://edabit.com", "b")); // "https://edabit.com"
    }
}