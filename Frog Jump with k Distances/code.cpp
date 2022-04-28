#include <bits/stdc++.h>
using namespace std;

int frogJump(int n, int k, vector<int> &heights, vector<int> &dp)
{
    dp[0] = 0;
    for (int i = 0; i < n; i++)
    {
        int minSteps = INT_MAX;
        for (int j = 1; j < k; j++)
        {
            if (i - j > 0)
            {
                int jump = dp[i - j] + abs(heights[i] - heights[i - j]);
                minSteps = min(minSteps, jump);
            }
        }

        dp[i] = minSteps;
    }

    return dp[n - 1];
}

int main()
{
    vector<int> arr{10, 30, 40, 50, 20};
    int stairs = arr.size();
    vector<int> dp(stairs, -1);
    int k = 3;
    frogJump(stairs, k, arr, dp);
    return 0;
}
