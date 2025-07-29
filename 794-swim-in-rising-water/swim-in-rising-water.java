class Solution {
    
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int s=grid[0][0],e=n*n-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(canSwim(grid,mid))e=mid;
            else s=mid+1;
        }return s;     
    }

    private boolean canSwim(int[][] grid,int mid){
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        return dfs(grid,visited,0,0,mid);
    }

    private boolean dfs(int[][] grid,boolean[][] visited,int i,int j,int mid){
        int n=grid.length;
        if(i<0  || j<0 ||j>=n  || i>=n || visited[i][j] || grid[i][j]>mid)return false;
        if(i==n-1 && j==n-1)return true;
        visited[i][j]=true;
     return dfs(grid,visited,i+1,j,mid) || dfs(grid,visited,i-1,j,mid)||
                        dfs(grid,visited,i,j+1,mid) ||dfs(grid,visited,i,j-1,mid);
    }
}