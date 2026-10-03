class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int end = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(ans == 0 || points[i][0] > end){
                ans++;
                end = points[i][1];
            }
        }
        return ans;
    }
}