class Solution {
    public int maxProfit(int[] prices) {
        int b=prices[0],p=Integer.MIN_VALUE;

        for(int i:prices){
            b=Math.min(b,i);
            p=Math.max(p,i-b);
        }return p;
    }
}