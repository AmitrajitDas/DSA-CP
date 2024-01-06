class Solution {

    // Binary search to find the lower bound index in the subsequence
    private int lowerBound(List<Integer> subsequence, int target) {
        int low = 0, high = subsequence.size() - 1;
        int res = subsequence.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // If the current element is less than the target, search in the right half
            if (subsequence.get(mid) < target) {
                low = mid + 1;
            } else {
                // If the current element is greater than or equal to the target, 
                // search in the left half and update the result index
                high = mid - 1;
                res = mid;
            }
        }

        // Return the lower bound index
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> subsequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Find the lower bound index in the subsequence for the current element
            int index = lowerBound(subsequence, nums[i]);

            // If the index is at the end of the subsequence, add the current element
            if (index == subsequence.size()) {
                subsequence.add(nums[i]);
            } else {
                // If not, update the element at the lower bound index with the current element
                subsequence.set(index, nums[i]);
            }
        }

        // Return the length of the final Longest Increasing Subsequence
        return subsequence.size();
    }
}


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] t = new int[n];
//         Arrays.fill(t, 1);
//         int maxLen = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i]) {
//                     t[i] = Math.max(t[i], t[j] + 1);
//                     maxLen = Math.max(maxLen, t[i]);
//                 }
//             }
//         }

//         return maxLen;
//     }
// }

// class Solution {
//     private int n;
//     private int[][] dp;

//     private int rec(int idx, int prevIdx, int[] nums) {
//         if (idx >= n) return 0;
//         if (dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];

//         int take = 0;
//         if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
//             take = 1 + rec(idx + 1, idx, nums);
//         }
//         int skip = rec(idx + 1, prevIdx, nums);


//         dp[idx][prevIdx + 1] = Math.max(take, skip);

//         return Math.max(take, skip);
//     }

//     public int lengthOfLIS(int[] nums) {
//         n = nums.length;
//         dp = new int[n + 1][n + 1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         return rec(0, -1, nums);
//     }
// }