class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.y - b.y);
        for(int i = 0;i < n;i++){
            pq.add(new Pair(nums[i][0] , nums[i][1]));
        }
        int end = Integer.MIN_VALUE;
        int cnt = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.x >= end){
                cnt++;
                end = p.y;
            }
        }
        return n - cnt;
    }

    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}