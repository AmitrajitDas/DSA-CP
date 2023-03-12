class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp1(n,1);
        vector<int> dp2(n,1);
        
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(nums[prev_index]<nums[i]){
                    dp1[i] = max(dp1[i], 1 + dp1[prev_index]);
                }
            }
        }
        
        // reverse the direction of nested loops
        for(int i=n-1; i>=0; i--){
            for(int prev_index = n-1; prev_index >i; prev_index --){
                
                if(nums[prev_index]<nums[i]){
                    dp2[i] = max(dp2[i], 1 + dp2[prev_index]);
                }
            }
        }
    
        int maxi = 0;
        
        for(int i=0; i<n; i++){
            if(dp1[i] > 1 && dp2[i] > 1) maxi = max(maxi, dp1[i] + dp2[i] - 1);
        }
        
        return n - maxi;
    }
};