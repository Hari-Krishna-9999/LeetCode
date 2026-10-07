class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            nums[i - 1] = i;
        }
        helper(nums , k , 0);
        return ans;
    }

    void helper(int[] nums ,int k , int idx){
        if(subset.size() == k){
            ans.add(new ArrayList<>(subset));
            return;
        }
        for(int i = idx;i < nums.length;i++){
            subset.add(nums[i]);
            helper(nums , k , i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}