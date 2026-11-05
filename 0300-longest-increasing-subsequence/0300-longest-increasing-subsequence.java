class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    arr[i] = Math.max(arr[i], 1 + arr[j]);
                }
            }
            max = Math.max(arr[i],max);
        }
        return max;
    }
}