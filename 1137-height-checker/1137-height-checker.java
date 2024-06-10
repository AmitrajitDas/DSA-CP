class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }

        int ans = 0;
        int j = 0;
        for (int i = 0; i < heights.length; i++) {
            while (j < count.length && count[j] == 0) {
                j++;
            }
            if (heights[i] != j) {
                ans++;
            }
            count[j]--;
        }
        return ans;
    }
}