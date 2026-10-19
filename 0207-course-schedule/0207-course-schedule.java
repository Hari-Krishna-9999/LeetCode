class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i < n;i++){
            al.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            al.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int v = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            v++;
            for(int ne : al.get(u)){
                indeg[ne] -= 1;
                if(indeg[ne] == 0){
                    q.add(ne);
                }
            }
        }
        return n == v;
    }
}