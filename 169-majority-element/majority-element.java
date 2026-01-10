class Solution {
    public int majorityElement(int[] nums) {
        int v=0,maj=nums[0];
        for(int i:nums){
            if(i==maj)v++;
            if(i!=maj)v--;
            if(v==0){v=1;maj=i;}
        }return maj;
    }
}