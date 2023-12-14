class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<int> onesRow(n, 0);
        vector<int> onesCol(m, 0);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
                // diff[i][j] = onesRowi + onesColj - (n - onesRowi) + (m - onesColj)
                // diff[i][j] = 2 * (onesRowi + onesColj) - n - m;
                grid[i][j] = 2 * (onesRow[i] + onesCol[j]) - n - m;
            }
        }

        return grid;
    }
};