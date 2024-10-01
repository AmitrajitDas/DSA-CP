class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mp = new int[k];  // Array to store remainder frequencies

        // Step 1: Calculate remainder frequencies for each element in the array
        for (int num : arr) {
            int rem = (num % k + k) % k;  // Normalize remainder to be non-negative
            mp[rem]++;  // Increment the count of this remainder
        }

        // Step 2: Check if the number of elements with remainder 0 is even
        if (mp[0] % 2 != 0) {
            return false;  // If remainder 0 has odd occurrences, pairing isn't possible
        }

        // Step 3: Check if the frequency of remainders matches with their complement remainder (k - rem)
        for (int rem = 1; rem <= k / 2; rem++) {
            int complement = k - rem;
            if (mp[complement] != mp[rem]) {
                return false;  // If the frequency doesn't match, pairing isn't possible
            }
        }

        // If all conditions are satisfied, return true
        return true;
    }
}
