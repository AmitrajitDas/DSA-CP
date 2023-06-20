class Solution {
public:
    typedef long long ll;
    ll MOD = 1e9 + 7;

    vector<vector<int>> pt;

    int dfs(vector<int>& nums) {
        int n = nums.size();
        if(n < 3) return 1;
        int root = nums[0];
        vector<int> left, right;
        for(int i = 1; i < n; i++) {
            if(nums[i] > root) right.push_back(nums[i]);
            else left.push_back(nums[i]);
        }

        ll leftWays = dfs(left) % MOD;
        ll rightWays = dfs(right) % MOD;
        ll ways = pt[n - 1][left.size()]; // nCr where n = n - 1 & r = left/right arr size

        return ((leftWays * rightWays) % MOD * ways) % MOD;
    }

    int numOfWays(vector<int>& nums) {
        int n = nums.size();
        pt.resize(n + 1);

        // creating the pascal's triangle to calculate nCr fast
        for(int i = 0; i <= n; i++) {
            pt[i] = vector<int>(i + 1, 1);
            for(int j = 1; j < i; j++) {
                pt[i][j] = (pt[i - 1][j] + pt[i - 1][j - 1]) % MOD;
            } 
        }

        return (dfs(nums) - 1) % MOD;
    }
};