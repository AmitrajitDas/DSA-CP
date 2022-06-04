class Solution {

    private int start, strlen;

    private void findPalindrome(String str, int low, int high) {

        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            low--;
            high++;
        }

        if ((high - low - 1) > strlen) { // to get the bounds of longest palindromic substring
            start = low + 1;
            strlen = high - low - 1;
        }

    }

    public String longestPalindrome(String s) {

        int n = s.length();
        
        if(n < 2) return s;
        
        for (int i = 0; i < n - 1; i++) {

            // we start from a particular point/points and spread sideways

            // for even length palindrome
            findPalindrome(s, i, i + 1);
            // for odd length palindrome
            findPalindrome(s, i, i);
        }

        return s.substring(start, start + strlen);
    }
}
