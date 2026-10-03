class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a , b) -> a[1] - b[1]);
        int prev = intervals[0][1];
        int cnt = 0;
        for(int i = 1;i < n;i++){
            if(prev > intervals[i][0]){
                cnt++;
            }else{
                prev = intervals[i][1];
            }
        }
        return cnt;
    }
}