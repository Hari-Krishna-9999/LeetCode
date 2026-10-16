class Solution {
    int[] x4 = {-1 , 0 , 1, 0};
    int[] y4 = {0 , 1, 0 , -1};
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int max = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    ans = dfs(grid , n , m, i , j, vis);
                    max = Math.max(ans , max);
                } 
            }
        }
        return max;
    }

    private int dfs(int[][] grid , int n ,int m,int si,int sj,boolean[][] vis){
        if(si < 0 || sj < 0 || si >= n || sj >= m || vis[si][sj] || grid[si][sj] == 0){
            return 0;
        }
        vis[si][sj] = true;
        int cnt = 1;
        for(int i = 0;i < 4;i++){
            int nr = x4[i] + si;
            int nc = y4[i] + sj;
            cnt += dfs(grid , n , m, nr,nc,vis);
        }
        return cnt;
    }
}