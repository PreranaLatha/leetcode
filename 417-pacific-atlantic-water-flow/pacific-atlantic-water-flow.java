class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==0 || heights[0].length==0)return new ArrayList<>();

    int row=heights.length;int col=heights[0].length;

    boolean[][] pacificReached=new boolean[row][col];
    boolean[][] atlanticReached=new boolean[row][col];

    for(int i=0;i<row;i++){
        dfs(i,0,pacificReached,heights);
        dfs(i,col-1,atlanticReached,heights);
    }

     for(int i=0;i<col;i++){
        dfs(0,i,pacificReached,heights);
        dfs(row-1,i,atlanticReached,heights);
    }
    List<List<Integer>> ans=new ArrayList<>();
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(pacificReached[i][j] && atlanticReached[i][j]){
                ans.add(List.of(i,j));
            }
        }
    }return ans;
    }

    private void dfs(int i,int j ,boolean[][] reach,int[][] heights){
        int[][] dir={{-1,0},{0,-1},{0,1},{1,0}};

        reach[i][j]=true;
        for(int[] d:dir){
            int newRow=i+d[0];
            int newCol=j+d[1];

            if(newRow<0 || newRow>=heights.length || newCol<0 || newCol>=heights[0].length)continue;
            if(reach[newRow][newCol])continue;
            if(heights[newRow][newCol] < heights[i][j])continue;

            dfs(newRow,newCol,reach,heights);
        }

        
    }
}