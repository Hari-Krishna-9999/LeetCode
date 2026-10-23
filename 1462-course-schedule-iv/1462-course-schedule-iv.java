class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] arr = new boolean[n][n];
        for(int[] pre : prerequisites){
            arr[pre[0]][pre[1]] = true;
        }
        for(int k = 0;k < n;k++){
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    if(arr[i][k] && arr[k][j]){
                        arr[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            ans.add(arr[q[0]][q[1]]);
        }
        return ans;
    }
}