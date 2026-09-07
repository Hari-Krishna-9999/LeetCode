class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < n;i++){
            int val = asteroids[i];
            if(val > 0){
                st.push(val);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -val){
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0){
                    st.push(val);
                }
                if(st.peek() == -val){
                    st.pop();
                }
            }
        }
        int[] ans = new int[st.size()];
        int idx = st.size() - 1;
        while(!st.isEmpty()){
            ans[idx--] = st.pop();
        }
        return ans;
    }
}