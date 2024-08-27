class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            // Calculate the middle index to avoid potential overflow
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }
            if ((nums[low] == nums[mid]) && (nums[mid] == nums[high])) {
                low++;
                high--;
            }
            // Check if the left half is sorted
            else if (nums[low] <= nums[mid]) {
                // If target is within the sorted left half, adjust the high pointer to search
                // in the left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }
                // Otherwise, adjust the low pointer to search in the right half
                else {
                    low = mid + 1;
                }
            }

            // If the right half is sorted
            else if (nums[mid] <= nums[high]) {
                // If target is within the sorted right half, adjust the low pointer to search
                // in the right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                // Otherwise, adjust the high pointer to search in the left half
                else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}