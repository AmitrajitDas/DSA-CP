class Solution {
    private int findMin(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    private int findMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);  // Update max if a larger value is found
        }
        return max;  // Return the maximum value in the array
    }

    private boolean isValid(int[] arr, int day, int m, int k) {
        int n = arr.length, count = 0, bouquets = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count / k;
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (long) m * (long) k) return -1;

        int low = findMin(bloomDay, n), high = findMax(bloomDay, n);

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValid(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}