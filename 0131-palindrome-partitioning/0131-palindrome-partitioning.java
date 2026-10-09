class Solution {
    List<List<String>> ans;
    List<String> list;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        int n = s.length();
        helper(s , n , 0);
        return ans;
    }

    void helper(String s, int n,int idx){
        if(idx >= n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx;i < n;i++){
            String str = s.substring(idx , i + 1);
            if(isPalindrome(str)){
                list.add(str);
                helper(s , n , i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isPalindrome(String s){
        int st = 0;
        int e = s.length() - 1;
        while(st < e){
            char ch1 = s.charAt(st);
            char ch2 = s.charAt(e);
            if(ch1 != ch2){
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
}