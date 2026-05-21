class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        // result array has n - k + 1 windows
        int[] res = new int[n - k + 1];
        // tracks how many consecutive increasing elements we have ending at 'end'
        int consecutive = 1;

        for (int end = 0; end < n; end++) {
            // extend the consecutive chain if current element is exactly 1 more than previous
            if (end > 0 && nums[end] == nums[end - 1] + 1) {
                consecutive++;
            } else {
                // chain broken, reset (current element starts a new chain)
                consecutive = 1;
            }

            // only start recording results once our first full window is complete
            if (end >= k - 1) {
                // if consecutive chain covers the entire window, max is nums[end]
                // (valid window is sorted ascending, so last element is always max)
                // otherwise mark -1
                res[end - k + 1] = consecutive >= k ? nums[end] : -1;
            }
        }

        return res;
    }
}