class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        int n = nums.size();
        
        // If the array has less than 2 elements, it is considered monotonic.
        if (n < 2) return true;
        
        int direction = 0; // 0 means unknown, 1 is increasing, -1 is decreasing

        for(int i = 1; i < n; i++) {
            // Compare the current element with the previous element.
            if(nums[i] > nums[i - 1]) {
                // If the current element is greater than the previous one,
                // and the direction is unknown, set it to increasing (1).
                if(direction == 0) direction = 1;
                // If the direction was already set to decreasing, return false
                // because it is not a monotonic array.
                else if(direction == -1) return false;
            } else if(nums[i] < nums[i - 1]) {
                // If the current element is less than the previous one,
                // and the direction is unknown, set it to decreasing (-1).
                if(direction == 0) direction = -1;
                // If the direction was already set to increasing, return false
                // because it is not a monotonic array.
                else if(direction == 1) return false;
            }
        }

        // If we have traversed the entire array without breaking the monotonicity,
        // return true, indicating that it is a monotonic array.
        return true;
    }
};
