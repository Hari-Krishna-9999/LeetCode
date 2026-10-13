class Solution {
    public void solveSudoku(char[][] board) {
        int n = 9;
        helper(board);
    }

    public boolean helper(char[][] board){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.'){
                    for(char target = '1' ; target <= '9';target++){
                        if(isSafe(board , i , j , target)){
                            board[i][j] = target;
                            if(helper(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board,int row , int col,char target){
        for(int i = 0;i < 9;i++){
            if(board[row][i] == target || board[i][col] == target){
                return false;
            }
        }
        int r = row / 3;
        int c = col / 3;
        r = r * 3;
        c = c * 3;
        for(int i = r;i < r + 3;i++){
            for(int j = c;j < c + 3;j++){
                if(board[i][j] == target){
                    return false;
                }
            }
        }
        return true;
    }
}