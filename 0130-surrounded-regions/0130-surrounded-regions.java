class Solution {
    int[] x4 = {-1 , 0 , 1 , 0};
    int[] y4 = {0 , 1, 0 , -1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i < m;i++){
            if(board[0][i] == 'O'){
                q.add(new Pair(0 , i));
                vis[0][i] = true;
            }
            if(board[n - 1][i] == 'O'){
                q.add(new Pair(n - 1, i));
                vis[n - 1][i] = true;
            }
        }
        for(int i = 0;i < n;i++){
            if(board[i][0] == 'O'){
                q.add(new Pair(i , 0));
                vis[i][0] = true;
            }
            if(board[i][m - 1] == 'O'){
                q.add(new Pair(i , m - 1));
                vis[i][m - 1] = true;
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4;i++){
                int nr = x4[i] + p.x;
                int nc = y4[i] + p.y;
                if(nr >= 0 && nc >= 0 && nr < n&& nc < m && board[nr][nc] == 'O' && !vis[nr][nc]){
                    q.add(new Pair(nr , nc));
                    vis[nr][nc] = true;
                }
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}