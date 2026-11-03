class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0;i < m;i++){
            if(grid[0][i] == 0){
                dp[0][i] = 1;
            }else{
                while(i < m){
                    dp[0][i] = 0; 
                    i++;
                }
            }
        }
        for(int i = 0;i < n;i++){
            if(grid[i][0] == 0){
                dp[i][0] = 1;
            }else{
                while(i < n){
                    dp[i][0] = 0; 
                    i++;
                }
            }
        }

        for(int i = 1;i < n;i++){
            for(int j = 1;j < m;j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        return dp[n - 1][m - 1];
    }
}