class Solution {
    List<List<Integer>> ans;
    List<Integer> per;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        per = new ArrayList<>();
        helper(nums , 0 , nums.length);
        return ans;
    }

    void helper(int[] nums, int idx,int n){
        if(idx >= n){
            ans.add(new ArrayList<>(per));
            return;
        }
        for(int i = idx;i < n;i++){
            swap(nums, idx , i);
            per.add(nums[idx]);
            helper(nums , idx + 1, n);
            swap(nums , idx , i);
            per.remove(per.size() - 1);
        }
    }

    void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}