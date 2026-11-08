class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < n - 1;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    ans.add(curr);
                    j++;
                    k--;
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }
}