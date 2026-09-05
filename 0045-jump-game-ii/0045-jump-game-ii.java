class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        if(n == 1) return 0;
        int jumps = 0;
        while(r < n - 1){
            int max = 0;
            for(int i = l;i <= r;i++){
                max = Math.max(i + nums[i] , max);
            }
            l = r + 1;
            r = max;
            jumps = jumps + 1;
        }
        return jumps;
    }
}