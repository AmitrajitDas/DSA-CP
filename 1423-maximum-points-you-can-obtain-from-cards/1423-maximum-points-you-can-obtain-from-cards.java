class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSum = 0;
        
        // Start: take all k from the left
        for (int i = 0; i < k; i++) {
            windowSum += cardPoints[i];
        }
        
        int maxSum = windowSum;
        
        // Slide: remove one from left, add one from right
        for (int i = 1; i <= k; i++) {
            windowSum += cardPoints[n - i];      // add from right
            windowSum -= cardPoints[k - i];      // remove from left
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
}