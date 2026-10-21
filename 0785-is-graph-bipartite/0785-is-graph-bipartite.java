class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0;i < n;i++){
            if(color[i] != 0){
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            color[i] = 1;
            q.add(i);
            while(!q.isEmpty()){
                int u = q.poll();
                for(int ne : graph[u]){
                    if(color[ne] == 0){
                        color[ne] = -color[u];
                        q.add(ne);
                    }else if(color[ne] == color[u]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}