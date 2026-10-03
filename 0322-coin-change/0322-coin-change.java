class Solution {
    Integer[][] dp;
    int INF = 1000000007;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[n + 1][amount + 1];
        return helper(coins , 0 , amount) == INF ? -1 : helper(coins , 0 , amount);
    }

    public int helper(int[] nums , int idx , int sum){
        if(idx >= nums.length || sum <= 0){
            return sum == 0 ? 0 : INF;
        }
        // if(sum == 0){
        //     return 0;
        // }
        if(dp[idx][sum] == null){
            int pick = 1 + helper(nums , idx , sum - nums[idx]);
            int notpick = helper(nums , idx + 1, sum);
            dp[idx][sum] = Math.min(pick , notpick);
        }
        return dp[idx][sum];
    }
}