class Solution {
    int[] x4 = {-1 , 0,  1, 0};
    int[] y4 = {0 , 1, 0 , -1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid , n , m, i , j,vis);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid , int n,int m,int si,int sj,boolean[][] vis){
        if(si < 0 || sj < 0 || si >= n || sj >= m || vis[si][sj] || grid[si][sj] == '0'){
            return;
        }
        vis[si][sj] = true;
        for(int i = 0;i < 4;i++){
            int nr = si + x4[i];
            int nc = sj + y4[i];
            dfs(grid, n , m, nr, nc , vis);
        }
    }
}