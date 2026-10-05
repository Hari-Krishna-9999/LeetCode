class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtracking(nums,0,subset,res);
        return res;
    }

    private void backtracking(int[] nums,int i,List<Integer> subset,List<List<Integer>> res){
        res.add(new ArrayList<>(subset));
        for(int j = i;j < nums.length;j++){
            if(j > i && nums[j] == nums[j - 1]){
                continue;
            }
            subset.add(nums[j]);
            backtracking(nums,j + 1,subset,res);
            subset.remove(subset.size() - 1);
        }
    }
}