// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:

    bool f(int i, int target,vector<int> &arr, vector<vector<int>> &dp) {
        
        if(i == 0) return arr[i] == target;
        if(target == 0) return true;
        if(dp[i][target] != -1) return dp[i][target];
        
        bool picked = f(i - 1, target - arr[i], arr, dp);
        bool notPicked = false;
        if(target >= arr[i])
            notPicked = f(i - 1, target, arr, dp);
        
        return dp[i][target] = picked || notPicked;
    }
    
    bool isSubsetSum(vector<int>arr, int sum){
        int n = arr.size();
        vector<vector<int>> dp(n, vector<int> (sum + 1, -1));
        return f(n - 1, sum, arr, dp); 
    }
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N, sum;
        cin >> N;
        vector<int> arr(N);
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        cin >> sum;
        
        Solution ob;
        cout << ob.isSubsetSum(arr, sum) << endl;
    }
    return 0; 
} 
  // } Driver Code Ends