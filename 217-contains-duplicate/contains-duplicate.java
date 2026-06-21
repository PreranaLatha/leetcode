class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> h=new HashSet<>();
        for(int i:nums){
            if(h.contains(i))return true;
            h.add(i);
        }return false;
    }
}