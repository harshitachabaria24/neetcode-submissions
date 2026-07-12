class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][]visited=new boolean[row][col];
        int maxarea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    
                    maxarea=Math.max(maxarea,dfs(grid,i,j,visited));
                }
            }
        }
        return maxarea;
    }
    public int dfs(int[][] grid,int row,int col,boolean[][] visited){
        if(row<0 || row >=grid.length || col<0 || col>= grid[0].length || grid[row][col]==0|| visited[row][col]){
            return 0;
        }
        visited[row][col]=true;
        int up=dfs(grid,row-1,col,visited);
        int down=dfs(grid,row+1,col,visited);
        int right=dfs(grid,row,col+1,visited);
        int left=dfs(grid,row,col-1,visited);

        return 1+(up+down+right+left);
        }
}
