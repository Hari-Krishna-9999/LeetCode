class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int val : nums){
            total += val;
        }
        if(total % 2 != 0){
            return false;
        }
        int sum = total / 2;
        dp = new Boolean[n + 1][sum + 1];
        return helper(nums , 0 , sum);
    }
    public boolean helper(int[] nums, int idx,int sum){
        if(sum == 0){
            return true;
        }
        if(sum < 0){
            return false;
        }
        if(idx == nums.length - 1){
            return sum == nums[idx];
        }
        if(dp[idx][sum] == null){
            boolean take = helper(nums, idx + 1,sum - nums[idx]);
            boolean nottake = helper(nums , idx + 1,sum);
            dp[idx][sum] = take || nottake;
        }
        return dp[idx][sum];
    }
}