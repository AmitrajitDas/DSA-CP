class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return 0;
        
        // for checking peak in first/last index
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        // check in the rest of the array
        int low = 1, high = n - 2;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if(nums[mid] < nums[mid + 1]) low = mid + 1;
            else if(nums[mid] < nums[mid - 1]) high = mid - 1;
        }

        return -1;
    }
};