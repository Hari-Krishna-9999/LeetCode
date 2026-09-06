class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        int[] arr = new int[2 * n];
        Arrays.fill(ans , -1);
        for(int i = 0;i < n;i++){
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 2 * n - 1; i >= 0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = arr[st.peek()];
            }
            st.push(i);
        }
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            res[i] = ans[i];
        }
        return res;
    }
}