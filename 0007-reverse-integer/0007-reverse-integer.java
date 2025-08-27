class Solution {
    /**
     * Reverses the digits of a 32-bit signed integer.
     * Returns 0 if the reversed integer overflows outside the range [-2^31, 2^31 - 1].
     * 
     * @param x the integer to reverse
     * @return the reversed integer, or 0 if overflow occurs
     */
    public int reverse(int x) {
        int rev = 0; // Initialize reversed number to 0
        
        // Continue processing while there are digits left in x
        while(x != 0) {
            // Check for overflow before multiplying by 10
            // If rev > MAX_VALUE/10, then rev*10 would exceed MAX_VALUE
            // If rev < MIN_VALUE/10, then rev*10 would be less than MIN_VALUE
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0; // Return 0 if overflow would occur
            }
            
            // Extract the last digit of x using modulo operator
            // Add it to rev after shifting rev one decimal place left
            rev = rev * 10 + x % 10;
            
            // Remove the last digit from x by integer division
            x /= 10;
        }
        
        return rev; // Return the reversed number
    }
}