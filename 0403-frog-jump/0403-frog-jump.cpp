class Solution {
private:
    int dp[2001][2001];  // Dynamic programming array for memoization
    unordered_map<int, int> mp;  // Map to store stone positions and indices
    int n;  // Total number of stones
    
    bool solve(int currStoneIdx, int prevJump, vector<int>& stones) {
        // Base case: Frog reached the last stone
        if (currStoneIdx == n - 1) return true;
        
        if (dp[currStoneIdx][prevJump] != -1) return dp[currStoneIdx][prevJump];

        bool res = false;
        

        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0) {  // Jump length must be positive
                int nextStone = stones[currStoneIdx] + nextJump;  // Calculate next stone position
                // Check if the next stone position exists in the map
                if (mp.find(nextStone) != mp.end()) {
                    // Recursively check if frog can jump to the next stone
                    res = res || solve(mp[nextStone], nextJump, stones);
                }
            }
        }

        // Store the result in the memoization array and return
        return dp[currStoneIdx][prevJump] = res;
    }
public:
    bool canCross(vector<int>& stones) {
        // Base case: Check if the second stone is reachable from the first stone
        if (stones[1] != 1) return false;
        
        n = stones.size();
        // Populate the map with stone positions and their indices
        for (int i = 0; i < n; i++) mp[stones[i]] = i;
        memset(dp, -1, sizeof(dp));
        // Call the recursive function starting from the first stone with 0 jump length
        return solve(0, 0, stones);
    }

};
