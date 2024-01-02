class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int res = neededTime[0], maxTime = neededTime[0];

        for(int i = 1; i < colors.size(); i++) {
            // Check if the current color is different from the previous one
            if(colors[i] != colors[i - 1]) {
                res -= maxTime; // If yes, subtract the maximum time needed for the previous color
                maxTime = 0; // Reset the maximum time for the current color
            }
            res += neededTime[i];
            maxTime = max(maxTime, neededTime[i]);
            // Thus res is incremented only when there's a repeating character with constant gap with maxTime
        }
        return res - maxTime;
    }
};