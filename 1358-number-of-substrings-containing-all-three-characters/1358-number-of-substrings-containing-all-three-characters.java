class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0; // Left pointer of the sliding window
        int res = 0; // Stores the total count of valid substrings
        
        // Map to keep track of the frequency of characters ('a', 'b', 'c') in the current window
        Map<Character, Integer> mp = new HashMap<>();
        
        // j is the right pointer expanding the sliding window
        for(int j = 0; j < n; j++) {
            // Include the current character at index j into the window
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            
            // While the window contains at least one of each: 'a', 'b', and 'c'
            while(mp.size() == 3) {
                /*
                 * MATH TRICK: If the substring from i to j is valid, then any substring
                 * starting at i and ending anywhere from j to the end of the string (n-1)
                 * is ALSO valid. There are exactly (n - j) such substrings.
                 */
                res += n - j;
                
                // Shrink the window from the left by removing/decrementing the character at index i
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                
                // If the count of that character drops to 0, completely remove it from the map
                if(mp.get(s.charAt(i)) == 0) {
                    mp.remove(s.charAt(i));
                }
                
                // Move the left pointer forward to check if a smaller window is still valid
                i++;
            }
        }

        return res;
    }
}