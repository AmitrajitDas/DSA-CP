class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        
        // OPTIMIZATION 1: Use a primitive array instead of a HashMap.
        // Index 0 -> 'a', Index 1 -> 'b', Index 2 -> 'c'
        int[] counts = new int[3]; 
        
        // Track the number of unique characters currently in the window
        int uniqueCount = 0;
        
        for (int j = 0; j < n; j++) {
            // Map the character to a 0-2 index range
            int rightChar = s.charAt(j) - 'a';
            
            // If this is a new character entering the window, track it
            if (counts[rightChar] == 0) {
                uniqueCount++;
            }
            counts[rightChar]++;
            
            // OPTIMIZATION 2: Replace mp.size() == 3 with a simple integer check
            while (uniqueCount == 3) {
                res += n - j;
                
                int leftChar = s.charAt(i) - 'a';
                counts[leftChar]--;
                
                // If a character's frequency drops to 0, we've lost a unique character
                if (counts[leftChar] == 0) {
                    uniqueCount--;
                }
                i++;
            }
        }

        return res;
    }
}