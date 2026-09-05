class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1;i >= 0;i--){
            int val = nums[i];
            while(!st.isEmpty() && nums[st.peek()] <= val){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}