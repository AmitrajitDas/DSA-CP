class Solution {
    private int validDivisor(int[] arr, int div) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + div - 1) / div; // This effectively performs ceiling division
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1; // Smallest possible divisor is 1
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (validDivisor(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
