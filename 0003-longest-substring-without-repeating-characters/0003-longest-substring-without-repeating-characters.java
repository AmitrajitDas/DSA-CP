class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        // Use Set<Character> to store characters, not integers
        Set<Character> charSet = new HashSet<>();
        
        // Sliding window approach using two pointers
        while (right < n) {
            char currentChar = s.charAt(right);
            
            // If current character is already in the window, shrink from left
            if (charSet.contains(currentChar)) {
                // Remove characters from left until the duplicate is removed
                charSet.remove(s.charAt(left));
                left++;
            } else {
                // Add current character to the set and expand window
                charSet.add(currentChar);
                right++;
                // Update maximum length found so far
                maxLen = Math.max(maxLen, charSet.size());
            }
        }
        
        return maxLen;
    }
}