// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

/// SPACE OPTIMIZATION ///

class Solution
{
public:
    bool isSubsetSum(vector<int> arr, int k)
    {
        int n = arr.size();
        vector<bool> prev(k + 1, false);

        prev[0] = true;

        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++)
        {
            vector<bool> cur(k + 1, false);
            cur[0] = true;
            for (int target = 1; target <= k; target++)
            {
                bool notTaken = prev[target];

                bool taken = false;
                if (arr[ind] <= target)
                    taken = prev[target - arr[ind]];

                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        return prev[k];
    }
};


/// TABULATION ///

// class Solution
// {
// public:
//     bool isSubsetSum(vector<int> arr, int k)
//     {
//         int n = arr.size();
//         vector<vector<bool>> dp(n, vector<bool>(k + 1, false));

//         for (int i = 0; i < n; i++)
//         {
//             dp[i][0] = true;
//         }

//         if (arr[0] <= k)
//             dp[0][arr[0]] = true;

//         for (int ind = 1; ind < n; ind++)
//         {
//             for (int target = 1; target <= k; target++)
//             {

//                 bool notTaken = dp[ind - 1][target];

//                 bool taken = false;
//                 if (arr[ind] <= target)
//                     taken = dp[ind - 1][target - arr[ind]];

//                 dp[ind][target] = notTaken || taken;
//             }
//         }

//         return dp[n - 1][k];
//     }
// };

/// MEMOIZATION ///

// class Solution
// {
// public:
//     bool f(int i, int target, vector<int> &arr, vector<vector<int>> &dp)
//     {

// base case
//         if (i == 0)
//             return arr[i] == target;
//         if (target == 0)
//             return true;
//         if (dp[i][target] != -1)
//             return dp[i][target];

//         bool picked = f(i - 1, target - arr[i], arr, dp);
//         bool notPicked = false;
//         if (target >= arr[i])
//             notPicked = f(i - 1, target, arr, dp);

//         return dp[i][target] = picked || notPicked;
//     }

//     bool isSubsetSum(vector<int> arr, int sum)
//     {
//         int n = arr.size();
//         vector<vector<int>> dp(n, vector<int>(sum + 1, -1));
//         return f(n - 1, sum, arr, dp);
//     }
// };

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N, sum;
        cin >> N;
        vector<int> arr(N);
        for (int i = 0; i < N; i++)
        {
            cin >> arr[i];
        }
        cin >> sum;

        Solution ob;
        cout << ob.isSubsetSum(arr, sum) << endl;
    }
    return 0;
}
// } Driver Code Ends
