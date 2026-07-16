class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

         Queue<int[]> q = new LinkedList<>();
         for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()) {
        int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if(newRow >= 0 &&
                   newRow < rows &&
                   newCol >= 0 &&
                   newCol < cols &&
                   grid[newRow][newCol] == Integer.MAX_VALUE) {

                    grid[newRow][newCol] = grid[row][col] + 1;

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
