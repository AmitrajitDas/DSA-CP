class Solution {
    // Instance variables to track the longest palindrome found so far
    private int maxLen = 0;    // Length of the longest palindrome
    private String res = "";   // The longest palindrome substring
    
    /**
     * Helper method to expand around center and find palindromes
     * @param i left pointer (center or left of center)
     * @param j right pointer (center or right of center)
     * @param s input string
     */
    private void findPalindrome(int i, int j, String s) {
        // Expand outward from center while characters match and indices are valid
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            // Calculate current palindrome length
            int currLen = j - i + 1;
            
            // Update result if current palindrome is longer than previous max
            if(currLen > maxLen) {
                res = s.substring(i, j + 1);  // Extract palindrome substring
                maxLen = currLen;             // Update max length
            }
            
            // Expand outward for next iteration
            i--;
            j++;
        }
    }
    
    /**
     * Main method to find the longest palindromic substring
     * Uses "expand around centers" approach
     * @param s input string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        
        // Handle edge cases: empty string or single character
        if(n < 2) {
            return s;
        }
        
        // Reset instance variables for fresh calculation
        maxLen = 0;
        res = "";
        
        // Check all possible centers in the string
        for(int i = 0; i < n; i++) {
            // Case 1: Odd-length palindromes (center is a single character)
            // Example: "aba" with center at 'b'
            findPalindrome(i, i, s);
            
            // Case 2: Even-length palindromes (center is between two characters)
            // Example: "abba" with center between the two 'b's
            findPalindrome(i, i + 1, s);
        }
        
        return res;
    }
}