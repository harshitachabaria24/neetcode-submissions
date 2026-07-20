class Solution {
    class Cell{
        int row;
        int col;
        int time;
        Cell(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int time[][]=new int[n][n];
        for(int[] row:time){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<Cell> pq =new PriorityQueue<>((a, b) -> a.time - b.time);
        int[][]directions={
            {0,1},{0,-1},{1,0},{-1,0}
        };
        time[0][0]=grid[0][0];
        pq.offer(new Cell(0,0,grid[0][0]));
         while (!pq.isEmpty()){
            Cell curr=pq.poll();
            int row=curr.row;
            int col=curr.col;
            int currtime=curr.time;
            if(currtime>time[row][col]){
                continue;
            }
            if(row==n-1 && col==n-1){
                return currtime;
            }
            for (int[] dir : directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(newRow<0|| newCol<0 || newRow >= n || newCol >= n)
                continue;

                int newTime=Math.max(currtime,grid[newRow][newCol]);
                if(newTime<time[newRow][newCol]){
                    time[newRow][newCol] = newTime;
                    pq.offer(new Cell(newRow, newCol, newTime));
                }
            }
         }
         return -1;

    }
}
