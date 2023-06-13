class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        map<vector<int>, int> mp; // map to store the frequency
        int n = grid.size(), m = grid[0].size();
        int res = 0;
        for(int i = 0; i < n; i++) mp[grid[i]]++; // storing rows
        for(int i = 0; i < n; i++) {
            vector<int> v;
            // extracting columns
            for(int j = 0; j < m; j++) v.push_back(grid[j][i]);
            res += mp[v]; // accumulating frequency
        }

        return res;
    }
};