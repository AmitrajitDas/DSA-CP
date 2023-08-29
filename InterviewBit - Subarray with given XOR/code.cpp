int Solution::solve(vector<int> &A, int B) {
    int n = A.size();
    unordered_map<int, int> mp;
    int xr = 0;
    mp[xr]++;
    int count = 0;
    
    for(int i = 0; i < n; i++) {
        xr ^= A[i];
        count += mp[xr ^ B];
        mp[xr]++;
    }
    return count;
}
