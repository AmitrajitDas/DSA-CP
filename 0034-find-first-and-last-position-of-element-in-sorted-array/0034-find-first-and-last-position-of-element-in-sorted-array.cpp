class Solution {
public:
    // Function to find the first occurrence of target in the sorted array
    int findFirst(vector<int> &nums, int target) {
        int idx = -1;
        int low = 0, high = nums.size() - 1;

        // Binary search to find the first occurrence of target
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the middle element is greater than or equal to target, search in the left half
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                // If the middle element is less than target, search in the right half
                low = mid + 1;
            }

            // Update the index if the middle element is equal to target
            if (nums[mid] == target) {
                idx = mid;
            }
        }

        // Return the index of the first occurrence of target
        return idx;
    }

    // Function to find the last occurrence of target in the sorted array
    int findLast(vector<int> &nums, int target) {
        int idx = -1;
        int low = 0, high = nums.size() - 1;

        // Binary search to find the last occurrence of target
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the middle element is less than or equal to target, search in the right half
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                // If the middle element is greater than target, search in the left half
                high = mid - 1;
            }

            // Update the index if the middle element is equal to target
            if (nums[mid] == target) {
                idx = mid;
            }
        }

        // Return the index of the last occurrence of target
        return idx;
    }

    // Function to search for the range of occurrences of target in the sorted array
    vector<int> searchRange(vector<int>& nums, int target) {
        // Create a vector to store the result range
        vector<int> res(2);

        // Find the first and last occurrences of target using the helper functions
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        // Return the result range
        return res;
    }
};