class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int n = arrays.size();
        for(int i = 1;i < n;i++){
            int m = arrays.get(i).size();
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(m - 1);
            ans = Math.max(ans , Math.max(Math.abs(currMax - min) , Math.abs(currMin - max)));
            min = Math.min(min , currMin);
            max = Math.max(max , currMax);
        }
        return ans;
    }
}