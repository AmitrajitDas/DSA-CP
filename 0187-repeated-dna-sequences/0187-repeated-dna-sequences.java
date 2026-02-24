class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        // edge case: no window of size 10 possible
        if (n <= 10) return new ArrayList<>();

        // map each DNA character to a digit (base-4 system)
        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A', 0);
        dnaMap.put('C', 1);
        dnaMap.put('G', 2);
        dnaMap.put('T', 3);

        int winLen = 10;  // fixed window size
        int base = 4;     // 4 possible characters → base 4
        
        // 4^9 = highest place value in a 10-digit base-4 number
        // used to remove the leftmost character from the hash
        long highPow = (long)Math.pow(base, winLen - 1);

        Set<Long> seen = new HashSet<>();       // hashes we've encountered once
        Set<String> repeated = new HashSet<>(); // substrings seen more than once

        // compute hash of the first window [0..9]
        // treat it like a 10-digit base-4 number
        long hash = 0;
        for(int i = 0; i < winLen; i++) {
            hash = hash * base + dnaMap.get(s.charAt(i));
        }
        seen.add(hash);

        // slide the window from index 1 to n-10
        for(int i = 1; i <= n - winLen; i++) {
            int leftChar  = dnaMap.get(s.charAt(i - 1));         // character sliding OUT
            int rightChar = dnaMap.get(s.charAt(i + winLen - 1)); // character sliding IN

            // rolling hash update:
            // 1. subtract leftChar's contribution (it was at the highest place value)
            // 2. shift everything left (*base)
            // 3. add the new rightChar at the lowest place value
            hash = (hash - leftChar * highPow) * base + rightChar;

            // if we've seen this hash before, it's a repeated sequence
            if(seen.contains(hash)) {
                repeated.add(s.substring(i, i + winLen)); // store actual string (handles hash collisions too)
            } else {
                seen.add(hash); // first time seeing this hash, record it
            }
        }

        return new ArrayList<>(repeated);
    }
}

/* Time Complexity: O(n)

The first loop (building initial hash) → O(10) = O(1)
The sliding window loop → O(n) iterations, each doing O(1) hash update
s.substring(i, i + 10) inside the loop → O(10) = O(1) since window is fixed size

So overall O(n) where n = length of string.

Space Complexity: O(n)

seen set → stores up to O(n) hashes
repeated set → stores up to O(n) substrings, each of fixed size 10 → O(n)

So overall O(n). */