class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        boolean[] column=new boolean[n];
        boolean[] diag1=new boolean[2*n-1];
        boolean[] diag2=new boolean[2*n-1];
        helper(0,n,board,column,diag1,diag2,ans);
        return ans;
    }
    public void helper(int row,int n,char[][] board,boolean[] column,boolean[] diag1,boolean[] diag2,List<List<String>>ans){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(char[] r:board){
                temp.add(new String(r));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            int leftdiagonal=row-col+n-1;
            int rightdiagonal=row+col;
         if (column[col] || diag1[leftdiagonal] || diag2[rightdiagonal]) {
                continue;
            }
        board[row][col] = 'Q';
            column[col] = true;
            diag1[leftdiagonal] = true;
            diag2[rightdiagonal] = true;

            helper(row + 1, n, board, column, diag1, diag2, ans);

            board[row][col] = '.';
            column[col] = false;
            diag1[leftdiagonal] = false;
            diag2[rightdiagonal] = false;
        }
    }
}
