class Solution {

    // This method finds the maximum value in the piles array.
    // It helps set the upper bound for the binary search.
    private int findMax(int[] piles, int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);  // Update max if a larger value is found
        }
        return max;  // Return the maximum value in the array
    }

    // This method calculates the total hours needed to eat all the bananas
    // if the eating speed is 'hours' bananas per hour.
    private int getTotalHours(int hours, int[] piles, int n) {
        int totalHours = 0;
        for(int i = 0; i < n; i++) {
            // Calculate the hours needed to eat the current pile at the given speed
            // We use Math.ceil to round up since we can't eat a partial pile
            totalHours += Math.ceil((double)piles[i] / (double)hours);
        }
        return totalHours;  // Return the total hours needed
    }

    // This method finds the minimum eating speed (bananas per hour) that allows Koko
    // to eat all the bananas within 'h' hours.
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;  // Get the number of piles
        int low = 1, high = findMax(piles, n);  // Initialize the binary search range

        // Binary search for the minimum eating speed
        while(low <= high) {
            int mid = low + (high - low) / 2;  // Calculate the middle point of the range
            int totalHours = getTotalHours(mid, piles, n);  // Calculate the total hours with the current speed

            // If Koko can eat all bananas within h hours at speed 'mid', try a slower speed
            if(totalHours <= h) {
                high = mid - 1;  // Look for a potentially slower speed by adjusting high
            } else {
                // If Koko can't eat all bananas within h hours at speed 'mid', increase the speed
                low = mid + 1;  // Look for a faster speed by adjusting low
            }
        }

        // Return the minimum speed found
        return low;
    }
}
