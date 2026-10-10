class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        boolean[][] vis = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(dfs(board,i,j,m,n,word,0,vis,len)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,int si,int sj,int m,int n,String word,int idx,boolean[][] vis,int len){
        if(len == idx){
            return true;
        }
        if(si < 0 || sj < 0 || si >= m || sj >= n || idx >= len || board[si][sj] != word.charAt(idx) || vis[si][sj]){
            return false;
        }
        vis[si][sj] = true;
        boolean isfound =   dfs(board , si - 1 ,sj , m , n,word, idx + 1,vis,len)   ||
                            dfs(board , si , sj + 1, m , n, word , idx + 1,vis,len) || 
                            dfs(board , si + 1, sj , m , n, word, idx + 1,vis,len)  || 
                            dfs(board , si , sj - 1,m , n, word, idx + 1,vis,len);
        vis[si][sj] = false;
        return isfound;
    }
}