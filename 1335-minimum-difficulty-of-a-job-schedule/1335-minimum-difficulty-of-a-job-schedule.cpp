class Solution {
	int n;
private:
	int rec(int idx, int d, vector<int> &jobDifficulty, vector<vector<int>> &dp) {
		if (d == 1) {
			int maxi = INT_MIN;
			for (int i = idx; i < n; i++) {
				maxi = max(jobDifficulty[i], maxi);
			}

			return maxi;
		}

		if (dp[idx][d] != -1) return dp[idx][d];

		int res = INT_MAX, leftMax = jobDifficulty[idx];
		for (int i = idx; i < n - d + 1; i++) {
			leftMax = max(jobDifficulty[i], leftMax);
			int rightMax = rec(i + 1, d - 1, jobDifficulty, dp);
			res = min(leftMax + rightMax, res);
		}

		return dp[idx][d] = res;
	}
public:
	int minDifficulty(vector<int>& jobDifficulty, int d) {
		n = jobDifficulty.size();
        if(n < d) return -1;
		vector<vector<int>> dp(n, vector<int> (d + 1, -1));
		return rec(0, d, jobDifficulty, dp);
	}
};