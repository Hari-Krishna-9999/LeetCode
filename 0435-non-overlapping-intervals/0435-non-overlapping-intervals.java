class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.y - b.y);
        for(int i = 0;i < n;i++){
            pq.add(new Pair(intervals[i][0] , intervals[i][1]));
        }
        int finish = Integer.MIN_VALUE;
        int cnt = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(finish <= p.x){
                cnt++;
                finish = p.y;
            }
        }
        return n - cnt;
    }
}

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}