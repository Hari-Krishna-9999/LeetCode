class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            color[i] = 1;
            q.add(i);

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int ne : graph.get(u)) {
                    if (color[ne] == 0) {
                        color[ne] = -color[u];
                        q.add(ne);
                    } else if (color[ne] == color[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}