class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];

        for(int j=0;j<cols;j++){
            dfs(heights,0,j,pacific);
        }
        for(int i=0;i<rows;i++){
            dfs(heights,i,0,pacific);
        }

        for(int j=0;j<cols;j++){
            dfs(heights,rows-1,j,atlantic);
        }
        for(int i=0;i<rows;i++){
            dfs(heights,i,cols-1,atlantic);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] heights,int row,int col,boolean[][] visited){
            if(visited[row][col]) {
            return;
            }
            visited[row][col] = true;

        // UP
        if(row - 1 >= 0 &&
           heights[row - 1][col] >= heights[row][col]) {

            dfs(heights, row - 1, col, visited);
        }
         // DOWN
        if(row + 1 < heights.length &&
           heights[row + 1][col] >= heights[row][col]) {

            dfs(heights, row + 1, col, visited);
        }

        // LEFT
        if(col - 1 >= 0 &&
           heights[row][col - 1] >= heights[row][col]) {

            dfs(heights, row, col - 1, visited);
        }

        // RIGHT
        if(col + 1 < heights[0].length &&
           heights[row][col + 1] >= heights[row][col]) {

            dfs(heights, row, col + 1, visited);
        }
    }
}
