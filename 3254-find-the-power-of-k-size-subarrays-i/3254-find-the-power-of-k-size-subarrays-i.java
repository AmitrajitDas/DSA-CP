class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int consecutive = 1;

        for (int end = 0; end < n; end++) {
            if (end > 0 && nums[end] == nums[end - 1] + 1) {
                consecutive++;
            } else {
                consecutive = 1;
            }

            if (end >= k - 1) {
                res[end - k + 1] = consecutive >= k ? nums[end] : -1;
            }
        }

        return res;
    }
}