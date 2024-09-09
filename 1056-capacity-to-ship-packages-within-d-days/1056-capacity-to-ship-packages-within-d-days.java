class Solution {
    // Method to calculate the number of days required to ship with a given weight capacity
    private int daysReq(int wt, int[] weights) {
        int days = 1, load = 0;  // Initialize the days and current load
        for (int w : weights) {
            // If adding the current weight exceeds capacity, we need a new day
            if (load + w > wt) {
                days++;
                load = w;  // Start new load with current weight
            } else {
                load += w;  // Add weight to current day's load
            }
        }
        return days;  // Return the total number of days required
    }

    // Main method to find the minimum ship capacity to ship within the given days
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();  // Minimum capacity should be at least the max weight
        int high = Arrays.stream(weights).sum();  // Maximum capacity could be the sum of all weights

        // Binary search to find the minimum capacity
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate mid capacity
            if (daysReq(mid, weights) > days) {
                low = mid + 1;  // If more days are required, increase capacity
            } else {
                high = mid - 1;  // If fewer or equal days are required, try lower capacity
            }
        }

        return low;  // The minimum capacity that allows shipping within the given days
    }
}
