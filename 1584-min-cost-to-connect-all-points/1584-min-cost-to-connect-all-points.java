class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<Pair>> al = new ArrayList<>();
        for(int i = 0;i < n;i++){
            al.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                int u1 = points[i][0];
                int v1 = points[i][1];
                int u2 = points[j][0];
                int v2 = points[j][1];
                int w = Math.abs(u1 - u2) + Math.abs(v1 - v2);
                al.get(i).add(new Pair(j , w));
                al.get(j).add(new Pair(i , w));
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> Integer.compare(a.w , b.w));
        pq.add(new Pair(0 , 0));
        int sum = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int v = p.v;
            int w = p.w;
            if(vis[v]){
                continue;
            }
            sum += w;
            vis[v] = true;
            for(Pair ne : al.get(v)){
                int v2 = ne.v;
                int w2 = ne.w;
                if(!vis[v2]){
                    pq.add(new Pair(v2 , w2));
                }
            }
        }
        return sum;
    }
}

class Pair{
    int v;
    int w;
    Pair(int v,int w){
        this.v = v;
        this.w = w;
    }
}