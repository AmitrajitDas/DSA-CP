class Solution {
public:
    int largestPerimeter(vector<int> &nums) {
        int maxPeri = INT_MIN;

        int n = nums.size();

        sort(nums.begin(), nums.end(), greater<int>());

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] < nums[i + 1] + nums[i + 2]) {
                maxPeri = max(nums[i] + nums[i + 1] + nums[i + 2], maxPeri);
                return maxPeri;
            }
            
        }
        
        return 0;
    }
};