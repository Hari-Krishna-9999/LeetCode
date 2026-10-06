class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        permutations(nums , 0);
        return ans;
    }
    void permutations(int[] nums, int idx){
        if(idx >= nums.length){
            List<Integer> list = new ArrayList<>();
            for(int val : nums){
                list.add(val);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> hset = new HashSet<>();
        for(int i = idx;i < nums.length;i++){
            if(hset.contains(nums[i])){
                continue;
            }
            hset.add(nums[i]);
            swap(nums , idx , i);
            permutations(nums , idx + 1);
            swap(nums , idx , i);
        }
    }
    void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}