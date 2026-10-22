class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> hset = new HashSet<>();
        Set<String> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for (String deadend : deadends) {
            hset.add(deadend);
        }
        if (hset.contains("0000")) {
            return -1;
        }
        q.add(new Pair("0000", 0));
        vis.add("0000");
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String s = p.x;
            int level = p.y;
            if (s.equals(target)) {
                return level;
            }
            for (int i = 0; i < 4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int newDigit = (s.charAt(i) - '0' + delta + 10) % 10;
                    String newString = s.substring(0, i) + newDigit + s.substring(i + 1);
                    if (!hset.contains(newString) && !vis.contains(newString)) {
                        q.add(new Pair(newString, level + 1));
                        vis.add(newString);
                    }
                }
            }
        }
        return -1;
    }
}

class Pair {
    String x;
    int y;

    Pair(String x, int y) {
        this.x = x;
        this.y = y;
    }
}