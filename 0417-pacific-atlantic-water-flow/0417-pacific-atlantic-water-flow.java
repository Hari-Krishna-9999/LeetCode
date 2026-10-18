class Solution {
    int[] x4 = {-1, 1, 0, 0};
    int[] y4 = {0, 0, -1, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    void dfs(int[][] heights, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + x4[i];
            int ny = y + y4[i];
            if (nx < 0 || ny < 0 ||
                nx >= heights.length || ny >= heights[0].length) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (heights[nx][ny] >= heights[x][y]) {
                dfs(heights, visited, nx, ny);
            }
        }
    }
}
