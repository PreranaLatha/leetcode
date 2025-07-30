public class Codec {

    HashMap<String, String> tinyUrl = new HashMap<>();
    public String encode(String longUrl) {
        String tiny = "";
        for(int i=((int)longUrl.length()/2)+1;i<longUrl.length();i++) {
            if('a' >= longUrl.charAt(i) && longUrl.charAt(i) <= 'z') {
                tiny += longUrl.charAt(i) - 'a';
            }
            if('A' >= longUrl.charAt(i) && longUrl.charAt(i) <= 'Z') {
                tiny += longUrl.charAt(i) - 'A';
            }
            if('0' >= longUrl.charAt(i) && longUrl.charAt(i) <= '9') {
                tiny += longUrl.charAt(i) - '0';
            }
        }
        tinyUrl.put(tiny,longUrl);
        return tiny;
    }

    public String decode(String shortUrl) {
        return tinyUrl.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));