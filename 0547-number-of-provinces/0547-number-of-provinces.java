class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] vis = new boolean[n + 1];
        for(int i = 0;i < n;i++){
            if(!vis[i]){
                ans++;
                dfs(isConnected , vis,i);
            }
        }
        return ans;
    }

    void dfs(int[][] arr,boolean[] vis,int si){
        if(vis[si]){
            return;
        }
        vis[si] = true;
        for(int i = 0;i < arr[si].length;i++){
            if(arr[si][i] == 1 && !vis[i]){
                dfs(arr,vis,i);
            }
        }
    }
}