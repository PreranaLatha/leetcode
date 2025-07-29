class Solution {
    public int minCostConnectPoints(int[][] points) {
       int n=points.length;
       boolean[] visited=new boolean[n];
       PriorityQueue<int[]> p=new PriorityQueue<>((a,b)->a[0]-b[0]);

       p.offer(new int[]{0,0});
       int totalCost=0,pointConnected=0;

       while(pointConnected<n){
        int[] cur=p.poll();
        int cost=cur[0],currentP=cur[1];

        if(visited[currentP])continue;
        visited[currentP]=true;
        totalCost+=cost;
        pointConnected++;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int distance=Math.abs(points[currentP][0]-points[i][0])+
                            Math.abs(points[currentP][1]-points[i][1]);
            p.offer(new int[]{distance,i});
            }
        }

       }return totalCost;
    }
}
