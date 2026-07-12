class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][]visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                    count++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int row,int col,boolean[][] visited){
        if(row<0 || row >=grid.length || col<0 || col>= grid[0].length || grid[row][col]=='0'|| visited[row][col]){
            return;
        }
        visited[row][col]=true;
        dfs(grid,row-1,col,visited);
        dfs(grid,row+1,col,visited);
        dfs(grid,row,col+1,visited);
        dfs(grid,row,col-1,visited);

    }
}
