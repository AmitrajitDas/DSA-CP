import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (j < n) {
            char currChar = s.charAt(j);
            if (!set.contains(currChar)) {
                set.add(currChar);
                maxLen = Math.max(maxLen, j - i + 1);
                j++; // Only move right pointer when we successfully expand
            } else {
                set.remove(s.charAt(i));
                i++; // Shrink window from left until duplicate is gone
            }
        }
        return maxLen;
    }
}