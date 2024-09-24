class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Step 1: Get the dimensions of the matrix (n rows and m columns)
        int n = matrix.length;      // Number of rows in the matrix
        int m = matrix[0].length;   // Number of columns in the matrix

        // Step 2: Set up binary search range, treating the 2D matrix as a 1D array
        // low and high represent the index range in this imaginary 1D array
        int low = 0, high = n * m - 1;

        // Step 3: Perform binary search
        while (low <= high) {
            // Calculate the middle index in this 1D representation
            int mid = low + (high - low) / 2;

            // Convert the 1D mid index back to 2D matrix coordinates
            int row = mid / m;   // Row index is mid divided by number of columns
            int col = mid % m;   // Column index is mid modulo number of columns

            // Step 4: Check if the current element is equal to the target
            if (matrix[row][col] == target) {
                return true;  // Target found, return true
            }

            // Step 5: Adjust search range
            // If the current element is greater than the target, search the left half
            if (matrix[row][col] > target) {
                high = mid - 1;  // Narrow down the search range to the left
            }
            // If the current element is less than the target, search the right half
            else {
                low = mid + 1;  // Narrow down the search range to the right
            }
        }

        // Step 6: If we exit the loop, the target is not in the matrix
        return false;
    }
}