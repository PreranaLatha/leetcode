class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> h=new HashSet<>();
        for(int i:nums)h.add(i);
        int len=0,longest=0;

        for(int j:h){
            if(!h.contains(j-1)){
                len=1;
                while(h.contains(j+len))len++;
            }longest=Math.max(longest,len);
        }return longest;
    }
}