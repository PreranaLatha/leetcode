class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ls=0,rs=0,ms=0;
        for(int i=0;i<k;i++){ls+= cardPoints[i];ms=ls;}
        int r= cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            ls-= cardPoints[i];
            rs+= cardPoints[r--];
            ms=Math.max(ms,ls+rs);
        }return ms;
    }
}