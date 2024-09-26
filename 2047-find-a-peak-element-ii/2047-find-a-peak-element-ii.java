class Solution {
    // Helper method to find the row index of the maximum element in a given column
    private int maxEle(int col, int[][] mat, int n) {
        int res = Integer.MIN_VALUE; // Initialize to smallest possible value
        int row = -1; // Variable to store the row index of the maximum element

        // Loop through each row and find the maximum element in the given column
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > res) {
                res = mat[i][col]; // Update the maximum value
                row = i; // Update the row index to the current row
            }
        }
        // Return the row index of the maximum element in the column
        return row;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns
        int low = 0, high = m - 1; // Binary search bounds for columns

        // Perform binary search to find the peak element
        while (low <= high) {
            int mid = low + (high - low) / 2; // Find the middle column
            int row = maxEle(mid, mat, n); // Find the row with the maximum element in the middle column

            // Get the values of the elements to the left and right of the current element
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1; // Element to the left, or -1 if out of bounds
            int right = mid + 1 < m ? mat[row][mid + 1] : -1; // Element to the right, or -1 if out of bounds
            int curr = mat[row][mid]; // Current element

            // Check if the current element is greater than both its left and right neighbors
            if (curr > left && curr > right) {
                return new int[]{row, mid}; // Return the row and column of the peak element
            }
            // If the current element is smaller than the element to the right, search in the right half
            else if (curr < right) {
                low = mid + 1; // Move to the right side of the matrix
            }
            // If the current element is smaller than the element to the left, search in the left half
            else {
                high = mid - 1; // Move to the left side of the matrix
            }
        }

        // If no peak element is found, return [-1, -1] (shouldn't happen as a peak element is guaranteed)
        return new int[]{-1, -1};
    }
}
