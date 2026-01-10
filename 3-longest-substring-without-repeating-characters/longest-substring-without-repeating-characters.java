class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,res=0;
        Map<Character,Integer> h=new HashMap<>();
        for(int r=0;r<s.length();r++){
            if(h.containsKey(s.charAt(r))){
                l=Math.max(l,h.get(s.charAt(r))+1);
            }h.put(s.charAt(r),r);
            res=Math.max(res,r-l+1);
        }return res;
    }
}