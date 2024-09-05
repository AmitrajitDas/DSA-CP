class Solution {
    
    // Method to find the minimum value in the array
    // This is used to set the lower bound for the binary search
    private int findMin(int[] arr, int n) {
        int min = Integer.MAX_VALUE;  // Initialize min to the largest possible integer value
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);  // Update min if a smaller value is found
        }
        return min;  // Return the minimum value in the array
    }

    // Method to find the maximum value in the array
    // This is used to set the upper bound for the binary search
    private int findMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;  // Initialize max to the smallest possible integer value
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);  // Update max if a larger value is found
        }
        return max;  // Return the maximum value in the array
    }

    // Helper function to check if we can make at least `m` bouquets by day `day`
    private boolean isValid(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int count = 0;  // To count consecutive flowers that bloom on or before the `day`
        int bouquets = 0;  // To count the number of bouquets we can make

        // Iterate through each flower
        for (int i = 0; i < n; i++) {
            // If the flower blooms on or before the given day
            if (arr[i] <= day) {
                count++;  // Increment count of consecutive blooming flowers
            } else {
                // If we have enough consecutive flowers for a bouquet
                bouquets += count / k;  // Add the possible bouquets
                count = 0;  // Reset count since this flower hasn't bloomed by `day`
            }
        }

        // After the loop, check if there are leftover flowers that can make another bouquet
        bouquets += count / k;

        // Return true if we can make at least `m` bouquets
        return bouquets >= m;
    }

    // Main function to find the minimum number of days needed to make `m` bouquets
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        // If we don't have enough flowers to make the required bouquets, return -1
        if (n < (long) m * (long) k) return -1;  // Avoid integer overflow with long multiplication

        // Initialize the binary search range: `low` is the minimum day, `high` is the maximum day
        int low = findMin(bloomDay, n), high = findMax(bloomDay, n);

        // Perform binary search to find the minimum day when we can make `m` bouquets
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Find the middle day (avoid overflow with this formula)

            // Check if we can make at least `m` bouquets by day `mid`
            if (isValid(bloomDay, mid, m, k)) {
                high = mid - 1;  // If yes, try to find an earlier day
            } else {
                low = mid + 1;  // If no, increase the day
            }
        }

        // After the binary search, `low` will be the minimum day when we can make the required bouquets
        return low;
    }
}
