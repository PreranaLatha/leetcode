class Solution {
    public int findDuplicate(int[] nums) {
        int s=nums[0],f=nums[0];
        for(int i=0;i<nums.length;i++){
            s=nums[s];f=nums[nums[f]];
            if(s==f)break;
        }

        int ss=nums[0];
        while(s!=ss){
            s=nums[s];
            ss=nums[ss];
        }return s;
    }
}