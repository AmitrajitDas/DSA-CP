class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Step 1: Get the dimensions of the matrix
        int n = matrix.length;       // Number of rows in the matrix
        int m = matrix[0].length;    // Number of columns in the matrix

        // Step 2: Start from the top-right corner of the matrix
        int row = 0;     // Start from the first row
        int col = m - 1; // Start from the last column (rightmost element of the first row)

        // Step 3: Traverse the matrix using the properties of the sorted matrix
        while (row < n && col >= 0) {
            // Step 4: If the current element is equal to the target, return true
            if (matrix[row][col] == target) {
                return true;
            }
            // Step 5: If the current element is less than the target, move down (increase row)
            // This is because all elements below are larger, so we move to the next row
            else if (matrix[row][col] < target) {
                row++;
            }
            // Step 6: If the current element is greater than the target, move left (decrease column)
            // This is because all elements to the left are smaller, so we move left
            else {
                col--;
            }
        }

        // Step 7: If the loop exits, the target was not found, return false
        return false;
    }
}
