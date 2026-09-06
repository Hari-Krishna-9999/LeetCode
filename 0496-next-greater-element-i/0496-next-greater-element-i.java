class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && nums2[st.peek()] <= nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                hmap.put(nums2[i] , nums2[st.peek()]);
            }
            st.push(i);
        }
        //System.out.println(hmap);
        int[] res = new int[nums1.length];
        for(int i = 0;i < nums1.length;i++){
            if(hmap.containsKey(nums1[i])){
                res[i] = hmap.get(nums1[i]);
            }else{
                res[i] = -1;
            }
        }
        return res;
    }
}