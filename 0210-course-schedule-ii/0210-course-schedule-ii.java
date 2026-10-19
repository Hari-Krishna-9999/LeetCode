class Solution {
    public int[] findOrder(int ver, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i < ver;i++){
            al.add(new ArrayList<>());
        }
        int[] indeg = new int[ver];
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            al.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < ver;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int v = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            for(int ne : al.get(u)){
                indeg[ne] -= 1;
                if(indeg[ne] == 0){
                    q.add(ne);
                }
            }
        }
        if(ans.size() != ver){
            return new int[]{};
        }
        int[] res = new int[ans.size()];
        for(int i = 0;i < ver;i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}