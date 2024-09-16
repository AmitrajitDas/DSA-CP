class Solution {
    private boolean canPlace(int limit, int[] arr, int totalBalls) {
        int ballsPlaced = 1;  // Place the first ball at the first position
        int prevPos = arr[0];  // The position of the first placed ball

        // Loop through the array and place balls with at least 'limit' distance apart
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prevPos >= limit) {  // Check if we can place a ball at arr[i]
                ballsPlaced++;  // Place the ball
                prevPos = arr[i];  // Update the position of the last placed ball
            }
            if (ballsPlaced == totalBalls) {  // If all balls are placed, return true
                return true;
            }
        }

        return false;  // If we cannot place all balls, return false
    }

    public int maxDistance(int[] position, int m) {
        // Step 1: Sort the position array
        Arrays.sort(position);

        // Step 2: Initialize the binary search boundaries
        int low = 1;  // Minimum possible distance
        int high = position[position.length - 1] - position[0];  // Maximum possible distance

        // Step 3: Perform binary search to find the maximum valid minimum distance
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate the middle distance

            // Check if we can place all 'm' balls with at least 'mid' distance
            if (canPlace(mid, position, m)) {
                low = mid + 1;  // Try for a larger minimum distance
            } else {
                high = mid - 1;  // Try for a smaller minimum distance
            }
        }

        // Step 4: Return the largest valid minimum distance
        return high;
    }
}