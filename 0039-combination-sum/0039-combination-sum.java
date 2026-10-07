class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        helper(nums, 0 , target);
        return ans;
    }

    public void helper(int[] nums,int idx , int target){
        if(target == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = idx;i < nums.length;i++){
            subset.add(nums[i]);
            helper(nums, i ,target - nums[i]);
            subset.remove(subset.size() - 1);
        }
    }
}