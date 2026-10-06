class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hmap = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(hmap.containsKey(nums[i])){
                int j = hmap.get(nums[i]);
                int abs = Math.abs(i - j);
                if(abs <= k){
                    return true;
                }
            }
            hmap.put(nums[i] , i);
        }
        return false;
    }
}