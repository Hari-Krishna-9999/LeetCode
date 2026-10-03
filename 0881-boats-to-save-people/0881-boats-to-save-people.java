class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while(l <= r){
            int sum = people[l] + people[r];
            if(sum <= limit){
                ans++;
                l++;
                r--;
            }else{
                ans++;
                r--;
            }
        }
        return ans;
    }
}