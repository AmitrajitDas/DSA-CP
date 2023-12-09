//// Simple Observation ////

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        int prefix = 1, suffix = 1, maxSoFar = INT_MIN;

        // Traverse the array from left to right and simultaneously from right to left.
        for (int i = 0; i < n; i++) {
            // If the prefix becomes zero, reset it to 1.
            if (prefix == 0) prefix = 1;
            
            // If the suffix becomes zero, reset it to 1.
            if (suffix == 0) suffix = 1;

            // Update the prefix and suffix products.
            prefix *= nums[i];
            suffix *= nums[n - i - 1];

            // Update the maximum product seen so far, considering the current prefix and suffix.
            maxSoFar = max(maxSoFar, max(prefix, suffix));
        }

        // Return the maximum product of a contiguous subarray.
        return maxSoFar;
    }
};

//// Kadane's Algo ////

// class Solution {
// public:
//     int maxProduct(vector<int>& nums) {
//         // Initialize variables to track the maximum product ending at the current position,
//         // the minimum product ending at the current position, and the maximum product so far.
//         int maxEndingHere = nums[0];
//         int minEndingHere = nums[0];
//         int maxSoFar = nums[0];

//         // Iterate through the array starting from the second element.
//         for (int i = 1; i < nums.size(); i++) {
//             // If the current number is negative, swap the maximum and minimum products.
//             if (nums[i] < 0) {
//                 swap(maxEndingHere, minEndingHere);
//             }

//             // Update the maximum and minimum products ending at the current position.
//             maxEndingHere = max(nums[i], maxEndingHere * nums[i]);
//             minEndingHere = min(nums[i], minEndingHere * nums[i]);

//             // Update the maximum product seen so far.
//             maxSoFar = max(maxSoFar, maxEndingHere);
//         }

//         // Return the maximum product of a contiguous subarray.
//         return maxSoFar;
//     }
// };