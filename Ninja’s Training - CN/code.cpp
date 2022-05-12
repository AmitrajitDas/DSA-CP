#include <bits/stdc++.h>
using namespace std;

/// Space Optimization ///

int ninjaTraining(int n, vector<vector<int>> &points)
{

    vector<int> prev(4, 0);

    prev[0] = max(points[0][1], points[0][2]);
    prev[1] = max(points[0][0], points[0][2]);
    prev[2] = max(points[0][0], points[0][1]);
    prev[3] = max(points[0][0], max(points[0][1], points[0][2]));

    for (int day = 1; day < n; day++)
    {

        vector<int> temp(4, 0);
        for (int last = 0; last < 4; last++)
        {
            temp[last] = 0;
            for (int task = 0; task <= 2; task++)
            {
                if (task != last)
                {
                    temp[last] = max(temp[last], points[day][task] + prev[task]);
                }
            }
        }

        prev = temp;
    }

    return prev[3];
}

int main()
{
    vector<vector<int>> points{{2, 1, 3}, {3, 4, 6}, {10, 1, 6}, {8, 3, 7}};
    int n = points.size();
    int res = ninjaTraining(n, points);
    cout << res << endl;
    return 0;
}

/// Tabulation ///

// int ninjaTraining(int n, vector<vector<int>> & points) {

//   vector<vector<int>> dp(n, vector<int> (4, 0));

//   dp[0][0] = max(points[0][1], points[0][2]);
//   dp[0][1] = max(points[0][0], points[0][2]);
//   dp[0][2] = max(points[0][0], points[0][1]);
//   dp[0][3] = max(points[0][0], max(points[0][1], points[0][2]));

//   for (int day = 1; day < n; day++) {
//     for (int last = 0; last < 4; last++) {
//       dp[day][last] = 0;
//       for (int task = 0; task <= 2; task++) {
//         if (task != last) {
//           int activity = points[day][task] + dp[day - 1][task];
//           dp[day][last] = max(dp[day][last], activity);
//         }
//       }
//     }

//   }

//   return dp[n - 1][3];
// }

/// Memoization ///

// int recur(int day, int last, vector<vector<int>> &points, vector<vector<int>> &dp)
// {

//     if (day == 0)
//     {
//         int maxi = 0;
//         for (int i = 0; i < 3; i++)
//         {
//             if (i != last)
//             {
//                 int point = points[0][i];
//                 maxi = max(maxi, point);
//             }
//         }
//         return maxi;
//     }

//     if (dp[day][last] != -1)
//         return dp[day][last];

//     int maxi = 0;
//     for (int i = 0; i < 3; i++)
//     {
//         if (i != last)
//         {
//             int point = points[day][i] + recur(day - 1, i, points, dp);
//             maxi = max(maxi, point);
//         }
//     }

//     return dp[day][last] = maxi;
// }

// int ninjaTraining(int n, vector<vector<int>> &points)
// {
//     vector<vector<int>> dp(n, vector<int>(4, -1));
//     return recur(n - 1, 3, points, dp);
// }

/// Recursion ///

// int recur(int day, int last, vector<vector<int>> &points)
// {

//     if (day == 0)
//     {
//         int maxi = 0;
//         for (int i = 0; i < 3; i++)
//         {
//             if (i != last)
//             {
//                 int point = points[0][i];
//                 maxi = max(maxi, point);
//             }
//         }
//         return maxi;
//     }

//     int maxi = 0;
//     for (int i = 0; i < 3; i++)
//     {
//         if (i != last)
//         {
//             int point = points[day][i] + recur(day - 1, i, points);
//             maxi = max(maxi, point);
//         }
//     }

//     return maxi;
// }

// int ninjaTraining(int n, vector<vector<int>> &points)
// {
//     return recur(n - 1, 3, points);
// }
