class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length, rows = mat.length, cols = mat[0].length;

        // Map to store the index of each number in `arr`
        Map<Integer, Integer> mp = new HashMap<>();

        // Initialize the minimum index to the maximum possible value
        int minIdx = Integer.MAX_VALUE;

        // Populate the map with the number as the key and its index in `arr` as the value
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }

        // Check each row of the matrix
        for (int row = 0; row < rows; row++) {
            // Variable to track the latest index (in terms of `arr`) for the current row
            int lastIdx = Integer.MIN_VALUE;

            for (int col = 0; col < cols; col++) {
                int val = mat[row][col]; // Value in the current cell
                int idx = mp.get(val);  // Retrieve the index of the value from the map
                lastIdx = Math.max(lastIdx, idx); // Update the latest index for this row
            }

            // Update the minimum index across all rows
            minIdx = Math.min(minIdx, lastIdx);
        }

        // Check each column of the matrix
        for (int col = 0; col < cols; col++) {
            // Variable to track the latest index (in terms of `arr`) for the current column
            int lastIdx = Integer.MIN_VALUE;

            for (int row = 0; row < rows; row++) {
                int val = mat[row][col]; // Value in the current cell
                int idx = mp.get(val);  // Retrieve the index of the value from the map
                lastIdx = Math.max(lastIdx, idx); // Update the latest index for this column
            }

            // Update the minimum index across all columns
            minIdx = Math.min(minIdx, lastIdx);
        }

        // Return the earliest index that completes a row or column
        return minIdx;
    }
}
