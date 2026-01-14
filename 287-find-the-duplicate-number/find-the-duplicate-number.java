class Solution {
    public int findDuplicate(int[] nums) {
        int ans=0;
        Set<Integer> h=new HashSet<>();

        for(int i:nums){
            if(h.contains(i))ans=i;
            h.add(i);
        }return ans;
    }
}