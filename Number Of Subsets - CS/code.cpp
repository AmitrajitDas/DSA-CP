int findWays(vector<int> &arr, int tar)
{
    int n = arr.size();
    vector<int> prev(tar + 1, 0);
    prev[0] = 1;
    if(arr[0] <= tar) prev[arr[0]] = 1;
    
    for(int idx = 1; idx < n; idx++) {
        vector<int> curr(tar + 1);
        curr[0] = 1;
        for(int sum = 0; sum <= tar; sum++) {
            
            int notTake = prev[sum];
            int take = 0;
            if(arr[idx] <= sum) 
                take = prev[sum - arr[idx]];
            
            curr[sum] = notTake + take;
        }
        
        prev = curr;
    }
    
    return prev[tar];
}
