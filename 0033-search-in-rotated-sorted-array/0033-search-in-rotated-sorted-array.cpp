class Solution {
public:
    // Function to perform a rotated sorted array search (modified binary search)
    int search(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if the middle element is equal to the target
            if (nums[mid] == target) {
                // If found, return the index
                return mid;
            } else if (nums[low] <= nums[mid]) {
                // If the left half is sorted
                // Check if the target is in the left half
                if (target >= nums[low] && target < nums[mid]) {
                    // Adjust the search space to the left half
                    high = mid - 1;
                } else {
                    // Adjust the search space to the right half
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) {
                // If the right half is sorted
                // Check if the target is in the right half
                if (target > nums[mid] && target <= nums[high]) {
                    // Adjust the search space to the right half
                    low = mid + 1;
                } else {
                    // Adjust the search space to the left half
                    high = mid - 1;
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }
};