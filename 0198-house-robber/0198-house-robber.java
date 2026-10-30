class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new Integer[n];
        return helper(nums , 0);
    }

    int helper(int[] nums ,int idx){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx] == null){
            int max = 0;
            int pick = nums[idx] + helper(nums , idx + 2);
            int notpick = helper(nums , idx + 1);
            max = Math.max(pick , notpick);
            dp[idx] = max;
        }
        return dp[idx];
    }
}