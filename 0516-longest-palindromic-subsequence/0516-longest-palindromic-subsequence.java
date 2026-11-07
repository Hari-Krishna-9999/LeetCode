class Solution {
    public int longestPalindromeSubseq(String s1) {
        StringBuilder sb = new StringBuilder(s1.toString()).reverse();
        String s2 = sb.toString();
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
}