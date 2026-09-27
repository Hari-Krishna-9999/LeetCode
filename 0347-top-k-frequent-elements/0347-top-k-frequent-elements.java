class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int val : nums){
            hmap.put(val , hmap.getOrDefault(val , 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> {
            if(a.fre == b.fre){
                return a.val - b.val;
            }
            return b.fre - a.fre;
        });
        for(int i = 0;i < n;i++){
            if(hmap.containsKey(nums[i])){
                int val = nums[i];
                int fre = hmap.get(val);
                pq.add(new Pair(val , fre));
                hmap.remove(val);
            }
        }
        int[] ans = new int[k];
        for(int i = 0;i < k;i++){
            Pair p = pq.poll();
            int val = p.val;
            ans[i] = val;
        }
        return ans;
    }
}

class Pair{
    int val;
    int fre;
    Pair(int val , int fre){
        this.val = val;
        this.fre = fre;
    }
}