class Solution {
    class Pair{
        int row;
        int col;
        int effort;

        Pair(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;

        int[][] effort=new int [rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(effort[i],Integer.MAX_VALUE);

        }
        effort[0][0]=0;
            PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.effort-b.effort);
             pq.offer(new Pair(0, 0, 0));
             int[] dr = {-1, 1, 0, 0};
             int[] dc = {0, 0, -1, 1};

             while(!pq.isEmpty()){
                Pair curr=pq.poll();
                int row=curr.row;
                int col=curr.col;
                int currEffort=curr.effort;

                if(currEffort>effort[row][col]){
                    continue;
                }
                if(row==rows-1 && col==cols-1){
                    return currEffort;
                }
                for(int i=0;i<4;i++){
                    int newRow=row+dr[i];
                    int newCol=col+dc[i];
                    if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols){
                        int diff=Math.abs(heights[row][col]-heights[newRow][newCol]);
                        int newEffort=Math.max(currEffort,diff);
                        if(newEffort<effort[newRow][newCol]){
                            effort[newRow][newCol]=newEffort;
                            pq.offer(new Pair(newRow,newCol,newEffort));
                        }
                    }
                }
           }
           return 0;
    }
}