class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Initialize binary search bounds
        int low = 0, high = arr.length - 1;

        // Perform binary search to find the right position
        while (low <= high) {
            // Calculate mid-point to split the search range
            int mid = low + (high - low) / 2;

            // Calculate how many numbers are missing up to arr[mid]
            // If arr[mid] is 5 and its index is 3, then 5 - (3 + 1) = 1 missing number up to that point
            int missing = arr[mid] - mid - 1;

            // If the number of missing numbers is less than k, search in the right half
            if (missing < k) {
                low = mid + 1;  // Move the lower bound to mid + 1
            } else {
                high = mid - 1; // Otherwise, move the upper bound to mid - 1
            }
        }

        // After the loop, low will point to the smallest index where k-th missing number can be found.
        // We return low + k because `low` indicates how many actual numbers we have in the array up to that point,
        // and we need to skip `k` missing numbers.
        return low + k;
    }
}
