class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] arr = new int[m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == '1'){
                    arr[j] += 1;
                }else{
                    arr[j] = 0;
                }
            }
            int[] nse = findNSE(arr);
            int[] pse = findPSE(arr);
            for(int k = 0;k < m;k++){
                int total = arr[k] * (nse[k] - pse[k] - 1);
                max = Math.max(total , max);
            }
        }
        return max;
    }
    int[] findNSE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans , n);
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    int[] findPSE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < n;i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}