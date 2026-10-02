class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_gas = 0;
        int total_cost = 0;
        for(int i = 0;i < n;i++){
            total_gas += gas[i];
            total_cost += cost[i];
        }
        if(total_gas < total_cost){
            return -1;
        }
        int curr_gas = 0;
        int start = 0;
        for(int i = 0;i < n;i++){
            curr_gas += gas[i];
            curr_gas -= cost[i];
            if(curr_gas < 0){
                curr_gas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}