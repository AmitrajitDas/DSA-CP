//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    int mod = 1e9 + 7;
	public:
	int perfectSum(int arr[], int n, int sum)
	{
	   vector<vector<int>> dp(n, vector<int> (sum+1, 0));
	 
	   if(arr[0] == 0){
	       dp[0][0] = 2;
	   }else{
	       dp[0][0] = 1;
	   }
	   if(arr[0] != 0 && arr[0] <= sum){
	       dp[0][arr[0]] = 1;
	   }
	   
	   for(int i =1;i<n;i++){
	       for(int target = 0;target<=sum;target++){
	           int notpick = dp[i-1][target] % mod;
	           int pick = 0;
	           if(arr[i] <= target){
	               pick = dp[i-1][target - arr[i]] % mod;
	           }
	           dp[i][target] = (notpick+pick)%mod;
	       }
	   }
	   return dp[n-1][sum]%mod;
	   
	}
	  
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends