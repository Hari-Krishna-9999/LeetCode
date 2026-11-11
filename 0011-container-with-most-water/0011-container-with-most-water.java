class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while(l < r){
            int min = Math.min(nums[l] , nums[r]);
            int area = min * (r - l);
            ans = Math.max(ans , area);
            if(nums[l] < nums[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}