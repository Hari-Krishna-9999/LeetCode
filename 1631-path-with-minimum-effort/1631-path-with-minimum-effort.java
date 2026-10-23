class Solution {
    int[] x4 = {-1 , 0, 1, 0};
    int[] y4 = {0 , 1, 0, -1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a , b) -> a.z - b.z);
        pq.add(new Tuple(0 , 0 , 0));
        int[][] dist = new int[n][m];
        int INF = Integer.MAX_VALUE;
        for(int[] d : dist){
            Arrays.fill(d , INF);
        }
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Tuple p = pq.poll();
            int i = p.x;
            int j = p.y;
            int diff = p.z;
            if(i == n - 1 && j == m - 1){
                return diff;
            }
            for(int d = 0;d < 4;d++){
                int nr = i + x4[d];
                int nc = j + y4[d];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int newEffort = Math.max(diff , Math.abs(heights[nr][nc] - heights[i][j]));
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new Tuple(nr , nc, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}

class Tuple{
    int x;
    int y;
    int z;
    Tuple(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}