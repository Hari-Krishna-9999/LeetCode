class Solution {
    int[] x4 = {-1 , 0 , 1, 0};
    int[] y4 = {0 , 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        dfs(image,n,m,sr,sc,color,target,vis);
        return image;
    }

    private void dfs(int[][] image,int n ,int m ,int si,int sj,int color,int target,boolean[][] vis){
        if(si < 0 || sj < 0 || si >= n || sj >= m || image[si][sj] != target || vis[si][sj]){
            return;
        }
        vis[si][sj] = true;
        image[si][sj] = color;
        for(int i = 0;i < 4;i++){
            int nr = x4[i] + si;
            int nc = y4[i] + sj;
            dfs(image,n,m,nr,nc,color,target,vis);
        }
    }
}