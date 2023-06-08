class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        int row = n - 1, col = 0;
        int count = 0;
        while(row >= 0 && col < m) {
            if(grid[row][col] < 0) {
                // if current index has -ve value then all the greater indices will also have -ve
                count += m - col; // m - col gives count of all the -ve values in that row
                row--; // and we go to the prev row
            } else col++; // if +ve value found then we check the next column
        }

        return count;
    }
};