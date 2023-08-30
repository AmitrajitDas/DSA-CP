class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        int n = nums.size();
        long long ops = 0; // To keep track of the total operations
        int parts = 0; // To store the number of parts

        // Loop through the array in reverse order starting from the second-to-last element
        for (int i = n - 2; i >= 0; i--) {
            // Check if the current number is greater than the next number
            if (nums[i] > nums[i + 1]) {
                // Calculate how many parts are needed to make the current number less than or equal to the next number
                parts = nums[i] / nums[i + 1];
                if (nums[i] % nums[i + 1] != 0) parts++; // If there's a remainder, add one more part
                ops += parts - 1; // Increment the total operations by (parts - 1)
                nums[i] /= parts; // Reduce the current number to make it less than or equal to the next number
            }
        }

        return ops;
    }
};
