class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0, count = 0;
        int[] charCount = new int[3];

        for(int right = 0; right < n; right++) {
            charCount[s.charAt(right) - 'a']++;
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                count += (n - right);
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}