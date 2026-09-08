class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = findNextSmaller(heights);
        int[] pse = findPrevSmaller(heights);
        int max = 0;
        for(int i = 0;i < n;i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max , area);
        }
        return max;
    }
    public int[] findNextSmaller(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans , n);
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] findPrevSmaller(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < n;i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
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