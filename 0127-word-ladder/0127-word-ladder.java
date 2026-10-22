class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hset = new HashSet<>();
        Set<String> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        for(String word : wordList){
            hset.add(word);
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.x;
            int level = p.y;
            if(s.equals(endWord)){
                return level;
            }
            int n = s.length();
            for(int i = 0;i < n;i++){
                char[] ch = s.toCharArray();
                for(char c = 'a' ; c <= 'z'; c++){
                    ch[i] = c;
                    String newString = new String(ch);
                    if(hset.contains(newString) && !vis.contains(newString)){
                        q.add(new Pair(newString , level + 1));
                        vis.add(newString);
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String x;
    int y;
    Pair(String x,int y){
        this.x = x;
        this.y = y;
    }
}