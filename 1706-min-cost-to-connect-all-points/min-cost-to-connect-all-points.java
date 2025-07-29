class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] visited = new int[points.length];
        Arrays.fill(visited,0);
        int[] mincost = new int[points.length];
        Arrays.fill(mincost,Integer.MAX_VALUE);
        int curr=0;
        mincost[0]=0;
        int res =0;
        while(curr>=0){
            visited[curr]=1;
            int next=-1;
            int mincurr=Integer.MAX_VALUE;
            for(int i=0;i<points.length;i++){
                if(visited[i]==1 || curr==i){continue;}
                mincost[i]=Math.min(mincost[i],(Math.abs(points[curr][0]-points[i][0])+Math.abs(points[curr][1]-points[i][1])));
                if(mincost[i]<mincurr){
                    mincurr=mincost[i];
                    next=i;
                }
            }
           if(mincurr==Integer.MAX_VALUE){
               res+=0;
           }
           else{
               res+=mincurr;
           }
           curr=next;
        }
        return res;
    }
}