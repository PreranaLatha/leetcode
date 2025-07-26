class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;

        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] e:edges){
              boolean[] vis=new boolean[n];
            if(isConnected(e[0]-1,e[1]-1,adj,vis)){
                return new int[]{e[0],e[1]};
            }
            adj[e[0]-1].add(e[1]-1);
            adj[e[1]-1].add(e[0]-1);
        }return new int[]{};
    }
    private boolean isConnected(int s,int e,List<Integer>[] adj, boolean[] vis){
        vis[s]=true;
        if(s==e)return true;

        boolean isFound=false;
        for(int ad:adj[s]){
            if(!vis[ad])
            isFound=isFound||isConnected(ad,e,adj,vis);
        }return isFound;
    }
}
