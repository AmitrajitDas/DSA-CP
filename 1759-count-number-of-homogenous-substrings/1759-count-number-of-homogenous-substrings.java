class Solution {
    // Define the constant for modulo operation
    static final int MOD = 1_000_000_007;

    public int countHomogenous(String s) {
        int n = s.length();
        int len = 1; // Initialize the length of the homogenous substring
        int res = 1; // Initialize the result, considering the single character substrings

        for (int i = 1; i < n; i++) {
            // Check if the current character is the same as the previous one
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++; // Increment the length of the homogenous substring
            } else {
                len = 1; // Reset the length if the current character is different
            }

            // Update the result by adding the current length and take modulo to prevent overflow
            res = (res + len) % MOD;
        }

        return res;
    }
}
