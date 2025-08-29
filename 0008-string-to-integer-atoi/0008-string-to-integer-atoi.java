class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int sign = 1;
        long result = 0; // Use long to handle overflow detection
        
        // Step 1: Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Handle sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits and handle overflow
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for overflow before updating result
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return (int) (result * sign);
    }
}