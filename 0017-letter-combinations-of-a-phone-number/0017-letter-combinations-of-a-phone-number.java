class Solution {
    List<String> ans;
    Map<Character , String> hmap;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        hmap = new HashMap<>(); 
        sb = new StringBuilder();
        hmap.put('2' , "abc");
        hmap.put('3' , "def");
        hmap.put('4' , "ghi");
        hmap.put('5' , "jkl");
        hmap.put('6' , "mno");
        hmap.put('7' , "pqrs");
        hmap.put('8' , "tuv");
        hmap.put('9' , "wxyz");
        helper(digits , 0);
        return ans;
    }

    void helper(String s,int idx){
        if(idx >= s.length()){
            ans.add(sb.toString());
            return;
        }
        String chocies = hmap.get(s.charAt(idx));
        for(char c : chocies.toCharArray()){
            sb.append(c);
            helper(s, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}