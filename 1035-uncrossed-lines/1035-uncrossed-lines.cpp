// TC: O(n * m), SC: O(n * m)
class Solution {
public:
    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), m = nums2.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1));
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(nums1[i - 1] == nums2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
};

// class Solution {
//     int dp[501][501];
// private:
//     int rec(int i, int j, vector<int>& nums1, vector<int>& nums2) {
//         if(i >= nums1.size() || j >= nums2.size()) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(nums1[i] == nums2[j]) return dp[i][j] = 1 + rec(i + 1, j + 1, nums1, nums2);
//         return dp[i][j] = max(rec(i + 1, j, nums1, nums2), rec(i, j + 1, nums1, nums2));
//     }
// public:
//     int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
//         memset(dp, -1, sizeof(dp));
//         return rec(0, 0, nums1, nums2);
//     }
// };