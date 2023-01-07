class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size(), total_surplus = 0, tank = 0, startIdx = 0; // total_surplus will give us a difference b/w gas & cost
        for(int i = 0; i < n; i++) {
            total_surplus += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0) { // if the tank goes -ve we reset our tank & update the stating gas station
                tank = 0;
                startIdx = i + 1;
            } 
        }

        return total_surplus < 0 ? -1 : startIdx;
    }
};