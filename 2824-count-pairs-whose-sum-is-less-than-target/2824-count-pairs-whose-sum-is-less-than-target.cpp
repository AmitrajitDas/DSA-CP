class Solution {
public:
    int countPairs(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int start = 0, end = nums.size() - 1;
        int count = 0;
        
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum < target) {
                count += end - start;
                start++;
            } else end--;
        }
        
        return count;
    }
};