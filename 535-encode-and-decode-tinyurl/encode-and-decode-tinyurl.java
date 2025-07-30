public class Codec {

    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    private Map<String, String> codeToUrl = new HashMap<>();
    private Map<String, String> urlToCode = new HashMap<>();
    private Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // If already encoded, return existing short URL
        if (urlToCode.containsKey(longUrl)) {
            return BASE_URL + urlToCode.get(longUrl);
        }

        // Generate a unique 6-character code
        String code = generateCode();
        while (codeToUrl.containsKey(code)) {
            code = generateCode(); // Avoid collision
        }

        codeToUrl.put(code, longUrl);
        urlToCode.put(longUrl, code);
        return BASE_URL + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.replace(BASE_URL, "");
        return codeToUrl.get(code);
    }

    // Helper to generate a random 6-character code
    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return sb.toString();
    }
}
