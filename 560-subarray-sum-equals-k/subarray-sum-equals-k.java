class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> h=new HashMap<>();
        int sum=0,c=0;
        h.put(0,1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(h.containsKey(sum-k))c+=h.get(sum-k);
            h.put(sum,h.getOrDefault(sum,0)+1);
        }return c;
    }
}