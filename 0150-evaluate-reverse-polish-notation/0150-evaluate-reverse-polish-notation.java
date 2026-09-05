class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int n = tokens.length;
        if(n == 1){
            return Integer.parseInt(tokens[0]);
        }
        for(int i = 0;i < n;i++){
            String s = tokens[i];
            boolean op = false;
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                op = true;
            }
            if(!op){
                int val = Integer.parseInt(s);
                st.push(val);
            }else{
                int val2 = st.pop();
                int val1 = st.pop();
                if(s.equals("+")){
                    ans = val1 + val2;
                }else if(s.equals("-")){
                    ans = val1 - val2;
                }else if(s.equals("*")){
                    ans = val1 * val2;
                }else if(s.equals("/")){
                    ans = val1 / val2;
                }
                st.push(ans);
            }
        }
        return ans;
    }
}