class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                
                int target = -nums[i];
                int low = i + 1, high = n - 1;
                while(low < high) {
                    if(nums[low] + nums[high] == target) {
                        vector<int> temp;
                        temp.push_back(nums[i]);
                        temp.push_back(nums[low]);
                        temp.push_back(nums[high]);
                        res.push_back(temp);
                        
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        
                        low++;
                        high--;
                    }
                    
                    else if (nums[low] + nums[high] < target) low++;
                    else high--;
                }
                
            }
            
        }
        
        return res;
    }
};