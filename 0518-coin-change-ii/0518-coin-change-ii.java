class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new Integer[n][amount + 1];
        int ans = helper(coins ,0 ,amount);
        return ans;
    }

    int helper(int[] nums , int idx ,int sum){
        if(sum == 0){
            return 1;
        }
        if(sum < 0 || idx == nums.length){
            return 0;
        }
        if(dp[idx][sum] == null){
            int take = helper(nums , idx,sum - nums[idx]);
            int nottake = helper(nums , idx + 1,sum);
            dp[idx][sum] = take + nottake;
        }
        return dp[idx][sum];
    }
}