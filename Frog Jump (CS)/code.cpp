#include <bits/stdc++.h>
using namespace std;

// recursion

int memo(int idx, vector<int> &heights)
{
    if (idx == 0)
        return 0;

    int l = memo(idx - 1, heights) + abs(heights[idx] - heights[idx - 1]);
    int r = INT_MAX;
    if (idx > 1)
        r = memo(idx - 2, heights) + abs(heights[idx] - heights[idx - 2]);

    return min(l, r);
}

int frogJumpRec(int n, vector<int> &heights)
{
    return memo(n - 1, heights);
}

// memoization

int memo(int idx, vector<int> &heights, vector<int> &dp)
{
    if (idx == 0)
        return 0;
    if (dp[idx] != -1)
        return dp[idx];

    int l = memo(idx - 1, heights, dp) + abs(heights[idx] - heights[idx - 1]);
    int r = INT_MAX;
    if (idx > 1)
        r = memo(idx - 2, heights, dp) + abs(heights[idx] - heights[idx - 2]);

    return dp[idx] = min(l, r);
}

int frogJump(int n, vector<int> &heights)
{
    vector<int> dp(n + 1, -1);
    return memo(n - 1, heights, dp);
}

// tabulation

int frogJump(int n, vector<int> &heights)
{
    vector<int> dp(n, 0);
    dp[0] = 0;

    for (int i = 1; i < n; i++)
    {
        int l = dp[i - 1] + abs(heights[i] - heights[i - 1]);
        int r = INT_MAX;
        if (i > 1)
            r = dp[i - 2] + abs(heights[i] - heights[i - 2]);

        dp[i] = min(l, r);
    }
    return dp[n - 1];
}

// optimization

int frogJump(int n, vector<int> &heights)
{
    int prev = 0, prev2 = 0;

    for (int i = 1; i < n; i++)
    {
        int l = prev + abs(heights[i] - heights[i - 1]);
        int r = INT_MAX;
        if (i > 1)
            r = prev2 + abs(heights[i] - heights[i - 2]);

        int curr = min(l, r);
        prev2 = prev;
        prev = curr;
    }
    return prev;
}

int main()
{
    vector<int> arr{10, 20, 30, 10};
    int n = arr.size();
    frogJump(n, arr);
    return 0;
}
