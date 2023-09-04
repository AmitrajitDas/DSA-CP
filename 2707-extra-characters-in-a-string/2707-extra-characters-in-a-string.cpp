class Solution {
    int n;
    int dp[51];
    unordered_set<string> st; // Set to store dictionary words

private:
    int solve(int idx, string s) {
        if (idx >= n) return 0; // Base case: If we have processed the entire string, no extra characters needed
        if (dp[idx] != -1) return dp[idx];
        string currStr = "";
        int minExtra = n;

        for (int i = idx; i < n; i++) {
            currStr += s[i]; // Build the current substring
            int currExtra = (st.find(currStr) == st.end()) ? currStr.length() : 0; // Calculate extra characters needed for the current substring
            int nextExtra = solve(i + 1, s); // Recursively compute extra characters needed for the rest of the string
            minExtra = min(minExtra, currExtra + nextExtra); // Update minExtra with the minimum of current and next extra characters
        }

        return dp[idx] = minExtra; // Store and return the computed result
    }

public:
    int minExtraChar(string s, vector<string>& dictionary) {
        n = s.length();
        memset(dp, -1, sizeof(dp));
        for (const string& it : dictionary) st.insert(it);
        return solve(0, s);
    }
};
