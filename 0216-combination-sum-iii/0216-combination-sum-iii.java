class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1 , 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> subset = new ArrayList<>();
        backtracking(nums , k , n, 0, ans , subset , 0);
        return ans;
    }

    private void backtracking(int[] nums ,int k , int target , int i,List<List<Integer>> ans,List<Integer> subset,int sum){
        if(i >= nums.length){
            if(k == subset.size() && sum == target){
                ans.add(new ArrayList<>(subset));
                return;
            }
        }
        if(subset.size() > k){
            return;
        }
        if(sum == target && k == subset.size()){
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int j = i;j < nums.length;j++){
            subset.add(nums[j]);
            backtracking(nums , k,target,j + 1,ans , subset,sum + nums[j]);
            subset.remove(subset.size() - 1);
        }
    }
}