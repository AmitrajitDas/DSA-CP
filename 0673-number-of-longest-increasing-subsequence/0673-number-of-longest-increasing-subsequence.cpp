class Solution {
public:
    int findNumberOfLIS(vector<int>& arr) {
        int n = arr.size();
    
        vector<int> dp(n,1);
        vector<int> ct(n,1);
        
        int maxi = 1;
        
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(arr[prev_index]<arr[i] && dp[prev_index]+1>dp[i]){
                    dp[i] = dp[prev_index]+1;
                    //inherit
                    ct[i] = ct[prev_index];
                }
                else if(arr[prev_index]<arr[i] && dp[prev_index]+1==dp[i]){
                    //increase the count
                    ct[i] = ct[i] + ct[prev_index];
                }
            }
            maxi = max(maxi,dp[i]);
        }
        
        int nos =0;
        
        for(int i=0; i<=n-1; i++){
        if(dp[i]==maxi) nos+=ct[i];
        }
        
        return nos;
    }
};