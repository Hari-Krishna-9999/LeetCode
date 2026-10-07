class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        helper(nums , 0, target);
        return ans;
    }


    void helper(int[] nums, int idx,int target){
        if(target == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = idx;i < nums.length;i++){
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }
            subset.add(nums[i]);
            helper(nums , i + 1 , target - nums[i]);
            subset.remove(subset.size() - 1);
        }
    }
}