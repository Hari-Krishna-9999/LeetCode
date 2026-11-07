class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1;i <= s.length();i++){
            for(String word : wordDict){
                int size = i - word.length();
                if(size >= 0 && dp[size] && s.substring(size,i).equals(word)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}