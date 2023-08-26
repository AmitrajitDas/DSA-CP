class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        int n = pairs.size();
        sort(begin(pairs), end(pairs)); // Sort the pairs based on the first element
        
        vector<int> dp(n, 1); // Initialize dp array with 1, as each pair is a valid chain of length 1
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1); // Update the length of chain ending at pair i
                }
            }
        }
        
        return *max_element(begin(dp), end(dp)); // Return the maximum chain length
    }
};