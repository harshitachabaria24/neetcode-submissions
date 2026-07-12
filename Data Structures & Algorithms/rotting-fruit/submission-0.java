class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue <int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)
        return 0;
        int minutes=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];
                if(row-1>=0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    fresh--;
                    q.offer(new int[]{row-1,col});
                }
                if(row+1<rows && grid[row+1][col]==1 ){
                    grid[row+1][col]=2;
                    fresh--;
                    q.offer(new int[]{row+1,col});
                }
                if(col-1>=0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    fresh--;
                    q.offer(new int[]{row,col-1});
                }
                if(col+1<cols && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    fresh--;
                    q.offer(new int[]{row,col+1});
                }
            }
            if(!q.isEmpty()){
                minutes++;
            }
        }
        if(fresh==0)
        return minutes;

        return -1;
    }
}
