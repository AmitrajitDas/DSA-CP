class Solution {
public:
    int findFirst(vector<int> &nums, int target) {
        int idx = -1;
        int low = 0, high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) high = mid - 1;
            else low = mid + 1;
            if(nums[mid] == target) idx = mid;
        }

        return idx;
    }

    int findLast(vector<int> &nums, int target) {
        int idx = -1;
        int low = 0, high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target) low = mid + 1;
            else high = mid - 1;
            if(nums[mid] == target) idx = mid;
        }

        return idx;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res(2);
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
};