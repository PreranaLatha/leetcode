public class Codec {

    private Map<Integer, String> map = new HashMap<>();
    private static final String BASE_HOST = "http://tinyurl.com/";
    private int id = 1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(id, longUrl);
        return BASE_HOST + id++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace(BASE_HOST, ""));
        return map.get(key);
    }
}
