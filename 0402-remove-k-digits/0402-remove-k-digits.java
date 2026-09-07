class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = num.length();
        if (k >= n) return "0";
        for (int i = 0; i < n; i++) {
            int curr = num.charAt(i) - '0';
            while (!st.isEmpty() && k > 0 && st.peek() > curr) {
                st.pop();
                k--;
            }
            st.push(curr);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        for (int digit : st) {
            sb.append(digit);
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        String result = sb.substring(i);
        return result.isEmpty() ? "0" : result;
    }
}