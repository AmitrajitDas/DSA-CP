class Solution {
    private int findMax(int[] piles, int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }
    private int getTotalHours(int hours, int[] piles, int n) {
        int totalHours = 0;
        for(int i = 0; i < n; i++) {
            totalHours += Math.ceil((double)piles[i] / (double)hours);
        }

        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = findMax(piles, n);

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int totalHours = getTotalHours(mid, piles, n);
            if(totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}