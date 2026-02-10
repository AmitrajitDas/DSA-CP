class Solution {
    private double solve(double x, long n) {
        if(n == 1) return x;
        if(n < 0) {
            return solve(1/x, -n);
        }
        if(n % 2 == 1) {
            return x * solve(x*x, n/2);
        }

        return solve(x*x, n/2);
    }

    public double myPow(double x, int n) {
        return solve(x, (long)n);
    }
}