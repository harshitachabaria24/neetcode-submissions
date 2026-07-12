class Solution {
    public void solve(char[][] board) {
        int rows=board.length;
        int col=board[0].length;
        for(int j=0;j<col;j++){
            if(board[0][j]=='O')
            dfs(board,0,j);
            if(board[rows-1][j]=='O')
            dfs(board,rows-1,j);
        }
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O')
            dfs(board,i,0);
            if(board[i][col-1]=='O')
            dfs(board,i,col-1);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                board[i][j]='X';
                else if(board[i][j]=='#')
                board[i][j]='O';
            }
        }
        
    }
    public void dfs(char[][] board,int rows,int col){
        if(rows<0 || rows>= board.length || col <0 || col>=board[0].length || board[rows][col] != 'O'){
            return;
        }
        board[rows][col]='#';
        dfs(board,rows-1,col);
        dfs(board,rows+1,col);
        dfs(board,rows,col-1);
        dfs(board,rows,col+1);
    }
}
