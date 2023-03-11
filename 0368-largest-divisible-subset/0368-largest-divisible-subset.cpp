class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int maxi = 1, lastIdx = 0;
        vector<int> dp(n, 1), hash(n);
        for(int i = 0; i < n; i++) {
            hash[i] = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }

            if(dp[i] > maxi) {
                maxi = dp[i];
                lastIdx = i;
            }
        }

        vector<int> res;
        res.push_back(nums[lastIdx]);
        while(lastIdx != hash[lastIdx]) {
            lastIdx = hash[lastIdx];
            res.push_back(nums[lastIdx]);
        }
        
        reverse(res.begin(), res.end());
        return res;
    }
};