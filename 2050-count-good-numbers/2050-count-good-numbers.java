class Solution {
    /**
     * Computes (base^expo) % mod efficiently using Binary Exponentiation algorithm.
     * This method implements the fast modular exponentiation technique with O(log expo) time complexity.
     *
     * @param base The base number to be raised to a power
     * @param expo The exponent (power) to which the base is raised
     * @param mod The modulus for all operations
     * @return The result of (base^expo) % mod as a long value
     */
    private long modPow(long base, long expo, long mod) {
        // Initialize result to 1 (identity element for multiplication)
        long res = 1;
        
        // Take modulo of base to handle large base values
        base = base % mod;
        
        // Continue until exponent becomes zero
        while(expo > 0) {
            // If current bit of exponent is 1, multiply result with current power of base
            if(expo % 2 == 1) {
                res = (res * base) % mod;
            }
            
            // Divide exponent by 2 (right shift by 1 bit)
            expo = expo >> 1;
            
            // Square the base for next iteration
            base = (base * base) % mod;
        }
        
        return res;
    }
    
    /**
     * Counts the number of "good" digit strings of length n.
     * A digit string is "good" if:
     * - Digits at even positions must be even numbers (0, 2, 4, 6, 8) - 5 options
     * - Digits at odd positions must be prime numbers (2, 3, 5, 7) - 4 options
     *
     * @param n The length of the digit string
     * @return The number of good digit strings of length n, modulo 10^9 + 7
     */
    public int countGoodNumbers(long n) {
        // Handle base case separately
        if(n == 1) {
            return 5; // Only one position (even position) with 5 choices
        }
        
        // Calculate the number of even and odd positions
        // - Even positions: positions 0, 2, 4, ... ((n+1)/2 positions)
        // - Odd positions: positions 1, 3, 5, ... (n/2 positions)
        long even = (n + 1) / 2;
        long odd = n / 2;
        
        // Modulus as specified in the problem
        int mod = 1_000_000_007;
        
        // Calculate 5^even * 4^odd % mod
        // - 5^even represents choices for even positions (0, 2, 4, 6, 8)
        // - 4^odd represents choices for odd positions (2, 3, 5, 7)
        return (int)(modPow(5, even, mod) * modPow(4, odd, mod) % mod);
    }
}