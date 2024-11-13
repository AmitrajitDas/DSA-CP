class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow when dividing Integer.MIN_VALUE by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Handle the sign of the result
        boolean isNeg = (dividend < 0) ^ (divisor < 0);

        // Convert to absolute values as long to prevent overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int quotient = 0;

        // Division using bit manipulation
        while (n >= d) {
            int count = 0;
            // Find the largest multiple of divisor (shifted) that is <= dividend
            while (n >= (d << (count + 1))) {
                count++;
            }
            // Add the multiple to the quotient
            quotient += (1 << count);
            // Subtract the scaled divisor from the dividend
            n -= (d << count);
        }

        // Apply the sign to the result
        return isNeg ? -quotient : quotient;
    }
}