class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int currCost = 0, maxLen = 0;
        int i = 0, j = 0;

        while (j < n) {
            // Calculate the difference cost for the current characters
            int diff = Math.abs(s.charAt(j) - t.charAt(j));
            currCost += diff;

            // If the current cost exceeds maxCost, shrink the window from the left
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }

            // Update the maximum length of the substring
            maxLen = Math.max(maxLen, j - i + 1);
            j++; // Move the right pointer to the next position
        }

        return maxLen;
    }
}
