int mod = (int)(1e9 + 7);
int countPartitions(int n, int d, vector<int> &arr)
{
    int totSum = accumulate(arr.begin(), arr.end(), 0);
    if((totSum - d) < 0 || (totSum - d) % 2 != 0) return false;
    int tar = (totSum - d)/2;
    vector<int> prev(tar + 1, 0);
    
    if(arr[0] <= 0) prev[0] = 2;
    else prev[0] = 1;
    
    if(arr[0] != 0 && arr[0] <= tar) prev[arr[0]] = 1;

    for(int idx = 1; idx < n; idx++) {
        vector<int> curr(tar + 1);
        curr[0] = 1;
        for(int sum = 0; sum <= tar; sum++) {

            int notTake = prev[sum];
            int take = 0;
            if(arr[idx] <= sum) 
                take = prev[sum - arr[idx]];

            curr[sum] = (notTake + take) % mod;
        }

        prev = curr;
    }

    return prev[tar];
}
