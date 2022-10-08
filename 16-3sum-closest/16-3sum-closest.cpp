class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int sum = nums[0] + nums[1] + nums[n - 1];
        int minDiff = sum;
        
        for(int i = 0; i < n - 2; i++) {
            int low = i + 1, high = n - 1;
            
            while(low < high) {
                sum = nums[i] + nums[low] + nums[high];
                
                if(sum < target) {
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    low++;
                }
                else if(sum > target) {
                    while(low < high && nums[high] == nums[high - 1]) high--;
                    high--;
                }
                else return sum;
                
                // updating min sum diff
                if(abs(target - sum) < abs(target - minDiff)) minDiff = sum;
            }
        }
        
        return minDiff;
    }
};