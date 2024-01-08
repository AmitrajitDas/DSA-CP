import java.util.Arrays;

class Solution {
    int n;
    private int getNextIdx(int low, int currJobEnd, int[][] pairs) {
        int high = n - 1;
        int res = n + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pairs[mid][0] >= currJobEnd) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] pairs = new int[n][3];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = startTime[i];
            pairs[i][1] = endTime[i];
            pairs[i][2] = profit[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = getNextIdx(i + 1, pairs[i][1], pairs);
            int take = pairs[i][2] + dp[nextIdx];
            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}


// class Solution {
//     int n;
//     private int getNextIdx(int low, int currJobEnd, int[][] pairs) {
//         int high = n - 1, res = n + 1;

//         while(low <= high) {
//             int mid = low + (high - low) / 2;
//             if(pairs[mid][0] >= currJobEnd) {
//                 res = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
        
//         return res;
//     }
//     private int memo(int idx, int[][] pairs, int[] dp) {
//         if(idx >= n) return 0;
//         if(dp[idx] != -1) return dp[idx];

//         int nextIdx = getNextIdx(idx + 1, pairs[idx][1], pairs);
//         int take = pairs[idx][2] + memo(nextIdx, pairs, dp);
//         int skip = memo(idx + 1, pairs, dp);

//         return dp[idx] = Math.max(take, skip);
//     }
//     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//         n = startTime.length;
//         int[][] pairs = new int[n][3];
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);

//         for(int i = 0; i < n; i++) {
//             pairs[i][0] = startTime[i];
//             pairs[i][1] = endTime[i];
//             pairs[i][2] = profit[i];
//         }

//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

//         return memo(0, pairs, dp);
//     }
// }