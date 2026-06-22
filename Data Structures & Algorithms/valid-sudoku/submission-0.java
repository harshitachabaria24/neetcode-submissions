class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen=new HashSet<>();
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char num=board[r][c];

                if(num == '.'){
                    continue;
                }
                String rowKey="row"+r+"-"+num;
                String colKey="col"+c+"-"+num;
                String boxKey="box"+(r/3)+"-"+(c/3)+"-"+num;

                if(seen.contains(rowKey)||
                seen.contains(colKey)||
                seen.contains(boxKey)){
                    return false;
                }
                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }
        return true;

        
    }
}
