class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, n = s.length(), res = 0, maxCount = 0;
        int[] charCount = new int[26];
        
        for (int j = 0; j < n; j++) {
            charCount[s.charAt(j) - 'A']++;
            maxCount = Math.max(charCount[s.charAt(j) - 'A'], maxCount);
            
            // window size - maxCount yields operations needed, 
            // if it's greater than k, shrink the window from the left
            while (j - i - maxCount + 1 > k) { 
                charCount[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(j - i + 1, res);
        }

        return res;
    }
}