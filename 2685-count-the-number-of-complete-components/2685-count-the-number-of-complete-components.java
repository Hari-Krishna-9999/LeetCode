class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i < n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            al.get(u).add(v);
            al.get(v).add(u);
        }
        int ans = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!vis[i]){
                int[] cnt = new int[2];
                dfs(i , vis , al , cnt);
                int node = cnt[0];
                int edgeSum = cnt[1] / 2;
                if(edgeSum == node * (node - 1) / 2){
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int val ,boolean[] vis , List<List<Integer>> al,int[] cnt){
        vis[val] = true;
        cnt[0]++;
        cnt[1] += al.get(val).size();
        for(int ne : al.get(val)){
            if(!vis[ne]){
                dfs(ne , vis,al,cnt);
            }
        }
    }
}