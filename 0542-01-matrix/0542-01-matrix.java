class Solution {
    int[] x4 = {-1 , 0 , 1, 0};
    int[] y4 = {0 , 1, 0 , -1};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i , j));
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0;i < 4;i++){
                int nr = x4[i] + p.x;
                int nc = y4[i] + p.y;
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == -1){
                   mat[nr][nc] = mat[p.x][p.y] + 1;
                   q.add(new Pair(nr , nc));
                }
            }
        }
        return mat;
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