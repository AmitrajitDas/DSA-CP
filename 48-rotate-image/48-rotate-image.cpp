class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        
        vector<vector<int>> temp(m, vector<int>(n));
        
        for(int i = 0; i < m; i++) 
        {
            for(int j = 0; j < n; j++)
            {
                temp[j][n - i - 1] = matrix[i][j];
            }
        }
        
        matrix = temp;
        
    }
};