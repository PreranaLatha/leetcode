class Solution {
    public int findDuplicate(int[] nums) {
      HashSet<Integer> h=new HashSet<>();
      int ans=0;
      for(int i:nums){
        if(h.contains(i))ans=i;
        h.add(i);
      }return ans;
    }
}