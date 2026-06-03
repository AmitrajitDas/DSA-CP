class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), i = 0, maxFreq = 0, res = 0;
        int[] charFreq = new int[26];

        for (int j = 0; j < n; j++) {
            charFreq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, charFreq[s.charAt(j) - 'A']);

            if (j - i + 1 - maxFreq > k) {
                charFreq[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}