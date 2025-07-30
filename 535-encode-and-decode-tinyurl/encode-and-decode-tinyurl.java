public class Codec {
    static int counter =0;
    HashMap<String, String> hm = new HashMap();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl)   {
       String key = Integer.toString(++counter);
     hm.put(key, longUrl);
     return key;
    }
        

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl)  {
        //String path = shortUrl.substring(shortUrl.lastIndexOf("/")+1);
        return hm.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));