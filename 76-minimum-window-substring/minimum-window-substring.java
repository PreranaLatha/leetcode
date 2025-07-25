class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()==0 || t.length()==0 || s.length()<t.length()){
            return new String();
        }

        int[] map=new int[128];
        int count=t.length();

        for(char c:t.toCharArray()){
            map[c]++;
        }

        char[] ch=s.toCharArray();

        int st=0,e=0,sI=0,min_length=Integer.MAX_VALUE;

        while(e<ch.length){
            if(map[ch[e++]]-->0)count--;
            while(count==0){
                if(e-st<min_length){
                sI=st;
                min_length=e-st;
                }
                if(map[ch[st++]]++==0)count++;
            }
        }return min_length==Integer.MAX_VALUE?new String():new String(ch,sI,min_length);
    }
}