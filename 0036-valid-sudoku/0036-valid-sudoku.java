class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(!isvalid(board,i,j,ch)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isvalid(char[][] board,int row,int col,char target){
        for(int i = 0;i < 9;i++){
            if(col != i && board[row][i] == target){
                return false;
            }
            if(row != i && board[i][col] == target){
                return false;
            }   
        }
        int r = row / 3;
        int c = col / 3;
        r = r * 3;
        c = c * 3;
        for(int i = r;i < r + 3;i++){
            for(int j = c;j < c + 3;j++){
                if((i != row && j != col) && board[i][j] == target){
                    return false;
                }
            }
        }
        return true;
    }
}