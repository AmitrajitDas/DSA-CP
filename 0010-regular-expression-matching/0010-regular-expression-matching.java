class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, s.length() - 1, p.length() - 1);
    }
    
    private boolean helper(String s, String p, int i, int j) {
        // Base case: if pattern is exhausted
        if (j < 0) {
            return i < 0;
        }
        
        // Base case: if string is exhausted but pattern remains
        if (i < 0) {
            // Pattern can only match if remaining pattern is like "a*b*c*"
            // Check if current and previous form a '*' pattern
            if (j > 0 && p.charAt(j) == '*') {
                return helper(s, p, i, j - 2);
            }
            return false;
        }
        
        // Check if current characters match
        boolean currentMatch = (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        
        // Check if current character in pattern is '*'
        if (p.charAt(j) == '*') {
            // '*' must have a preceding character
            char prevChar = p.charAt(j - 1);
            boolean prevMatch = (prevChar == s.charAt(i) || prevChar == '.');
            
            // Two choices:
            // 1. Don't use the '*' (match zero occurrences) - skip pattern[j-1:j]
            // 2. Use the '*' if preceding character matches - consume string[i]
            return helper(s, p, i, j - 2) || 
                   (prevMatch && helper(s, p, i - 1, j));
        } else {
            // No '*', so we must match current character and move backward
            return currentMatch && helper(s, p, i - 1, j - 1);
        }
    }
}