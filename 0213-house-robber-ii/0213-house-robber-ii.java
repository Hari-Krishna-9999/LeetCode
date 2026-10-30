class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);
        Integer[] dp1 = new Integer[n];
        int first = helper(nums , 0 , n - 2 ,dp1);
        Integer[] dp2 = new Integer[n];
        int second = helper(nums , 1 , n - 1 , dp2);
        return Math.max(first , second);
    }

    int helper(int[] nums ,int idx,int n,Integer[] dp){
        if(idx > n){
            return 0;
        }
        if(dp[idx] == null){
            int max = 0;
            int pick = nums[idx] + helper(nums , idx + 2 , n , dp);
            int notpick = helper(nums , idx + 1, n , dp);
            max = Math.max(pick , notpick);
            dp[idx] = max;
        }
        return dp[idx];
    }
}