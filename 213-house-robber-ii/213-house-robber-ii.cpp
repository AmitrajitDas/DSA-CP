class Solution {
public:
    // Function from House of Robber //
    int maxSum(vector<int>& nums) {
        int n = nums.size();
        int prev = nums[0], prev2 = 0;
        
        for(int i = 1; i < n; i++) {
            
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notPick = 0 + prev;
            
            int curr = max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
    
    int rob(vector<int>& nums) {
        vector<int> temp1, temp2;
        int n = nums.size();
        if(n == 1) return nums[0];
        
        for(int i = 0; i < n; i++) {
            if(i > 0) temp1.push_back(nums[i]); // we'll push all elements except 1st index to temp1
            if(i < n - 1) temp2.push_back(nums[i]); // and all elements except last index to temp2
            // so that we don't rob from 1st and last index houses which adjacent
        }
        
        return max(maxSum(temp1), maxSum(temp2));
        
    }
};