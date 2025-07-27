class Solution {
    public int maxArea(int[] height) {
        int a=0,mA=0;
        int l=0,r=height.length-1;
        while(l<=r){
            a=Math.min(height[l],height[r])*(r-l);
            mA=Math.max(mA,a);
            if(height[l]<height[r])l++;
            else    r--;
            
        }return mA;
    }
}