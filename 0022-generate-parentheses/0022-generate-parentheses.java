class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(2 * n, 0 , 0, 0 ,sb);
        return ans;
    }
    void helper(int n,int idx,int open,int close,StringBuilder sb){
        if(idx == n){
            ans.add(sb.toString());
            return;
        }
        if(open < n / 2){
            sb.append('(');
            helper(n , idx + 1,open + 1, close ,sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(')');
            helper(n , idx + 1,open , close + 1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}