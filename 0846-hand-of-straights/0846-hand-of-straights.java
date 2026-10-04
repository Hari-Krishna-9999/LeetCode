class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        for(int i =0 ;i < n;i++){
            tmap.put(hand[i] , tmap.getOrDefault(hand[i] , 0) + 1);
        }
        while(!tmap.isEmpty()){
            int key = tmap.firstKey();
            for(int i = 0;i < groupSize;i++){
                int val = key + i;
                if(!tmap.containsKey(val)){
                    return false;
                }
                int fre = tmap.get(val);
                if(fre == 1){
                    tmap.remove(val);
                }else{
                    tmap.put(val , tmap.get(val) - 1);
                }
            }
        }
        return true;
    }
}