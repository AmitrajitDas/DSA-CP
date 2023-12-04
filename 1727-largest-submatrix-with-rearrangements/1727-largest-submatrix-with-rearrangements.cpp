class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();
        int res = 0;
        vector<int> height(m, 0); // Vector to store the heights of histograms
		
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // Update the height vector based on the current element in the matrix
                if(matrix[i][j] == 0) height[j] = 0;
                else height[j] += 1;
            }
			
            // Create a copy of the height vector and sort it in non-decreasing order
            vector<int> order_height = height;
            sort(order_height.begin(), order_height.end());

            // Iterate through each position to calculate the area of the largest rectangle
            for(int i = 0; i < m; i++){
                // Calculate the area of the rectangle at the current position
                res = max(res, order_height[i] * (m - i));
            }
        }
        return res;
    }
};
