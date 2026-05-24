class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, n = fruits.length, maxlen = 0;
        // Map to track count of each fruit type in current window
        Map<Integer, Integer> mp = new HashMap<>();

        // Expand window by moving right pointer
        while (j < n) {
            // Add fruit at j to the window
            mp.put(fruits[j], mp.getOrDefault(fruits[j], 0) + 1);

            // Shrink window from left until we have at most 2 fruit types
            while (mp.size() > 2) {
                // Remove one instance of the leftmost fruit
                mp.put(fruits[i], mp.get(fruits[i]) - 1);
                // If no more of this fruit in window, remove it from map
                if (mp.get(fruits[i]) == 0) {
                    mp.remove(fruits[i]);
                }
                i++;
            }

            // Update max window size seen so far
            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }

        return maxlen;
    }
}