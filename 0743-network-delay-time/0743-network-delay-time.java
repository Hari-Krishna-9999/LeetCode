class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE;
        List<List<Pair>> al = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            al.add(new ArrayList<>());
        }

        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            al.get(u).add(new Pair(v , w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.y - b.y);
        pq.add(new Pair(k , 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist , INF);
        dist[k] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.x;
            int w = p.y;
            if(w > dist[u]){
                continue;
            }
            for(Pair ne : al.get(u)){
                int v = ne.x;
                int w1 = ne.y;
                if(dist[v] > w + w1){
                    dist[v] = w + w1;
                    pq.add(new Pair(v , dist[v]));
                }
            }
        }
        int max = 0;
        for(int i = 1;i <= n;i++){
            int val = dist[i];
            if(val == INF){
                return -1;
            }
            max = Math.max(val , max);
        }
        return max;
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