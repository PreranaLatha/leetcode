class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        res[0]=search(nums,target,true);
        res[1]=search(nums,target,false);
       
       return res;
    }
    private int search(int[] nums,int target,boolean ll){
        int l=0,r=nums.length-1;
        int rr=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                rr=mid;
                if(ll)r=mid-1;
                else l=mid+1;
            }else if(nums[mid]<target)l=mid+1;
            else r=mid-1;
        }return rr;
    }
}