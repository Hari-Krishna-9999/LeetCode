class Solution {
    int[] x4 = {-1 , 0, 1, 0};
    int[] y4 = {0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i , j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean change = false;
            for(int j = 0;j < size;j++){
                Pair p = q.poll();
                for(int i = 0;i < 4;i++){
                    int nr = x4[i] + p.x;
                    int nc = y4[i] + p.y;
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new Pair(nr , nc));
                        fresh--;
                        change = true;
                    }
                }
            }
            if(change){
                ans++;
            }
        }
        return fresh == 0 ? ans : -1;
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