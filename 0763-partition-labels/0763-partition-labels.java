class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> hmap = new HashMap<>();
        int n = s.length();
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            hmap.put(ch , i);
        }
        int max = 0;
        int prev = -1;
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            max = Math.max(max , hmap.get(ch));
            if(max == i){
                ans.add(max - prev);
                prev = max;
            }
        }
        return ans;
    }
}