class Solution {
    public int trap(int[] height) {
      int lmax=0,rmax=0,ans=0;
        int l=0,r=height.length-1;
        while(l<=r){
            lmax=Math.max(height[l],lmax);
            rmax=Math.max(height[r],rmax);
            ans+=(lmax<rmax)?lmax-height[l++]:rmax-height[r--];
        }return ans;   
    }
}