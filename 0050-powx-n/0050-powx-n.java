// Time Complexity (TC): O(log n)
// Space Complexity (SC): O(log n)

// Binary Exponentiation is an efficient algorithm for calculating
// the power of a number 'x' raised to the power 'n'.
class Solution {
    // Helper function to perform binary exponentiation recursively.
    // The function takes the base 'x' and the exponent 'n'.
    private double solve(double x, long n) {
        // Base case: if the exponent is 0, return 1 as any number
        // raised to the power of 0 is 1.
        if (n == 0) return 1;

        // If the exponent is negative, we use the property:
        // x^n = 1 / (x^-n). So, we call the solve function with 1/x
        // as the base and -n as the exponent.
        if (n < 0) return solve(1 / x, -n);

        // If the exponent is even, we use the property:
        // x^n = (x^2)^(n/2). So, we call the solve function with
        // x*x as the base and n/2 as the exponent.
        if (n % 2 == 0) return solve(x * x, n / 2);

        // If the exponent is odd, we use the property:
        // x^n = x * (x^2)^(n/2). So, we call the solve function with
        // x*x as the base and n/2 as the exponent, and multiply the
        // result with 'x'.
        return x * solve(x * x, n / 2);
    }

    // Main function to calculate x raised to the power of n.
    public double myPow(double x, int n) {
        // We convert the exponent 'n' to a long type to handle
        // cases where 'n' is Integer.MIN_VALUE, which would cause
        // overflow if not converted to long.
        return solve(x, (long) n);
    }
}
