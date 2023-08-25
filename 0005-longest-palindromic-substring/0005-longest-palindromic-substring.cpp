class Solution {
private:
    string res = "";  // Stores the longest palindromic substring
    int maxLen = 0;   // Stores the length of the longest palindromic substring

    // Helper function to find palindromic substring around a center
    void findPalindrome(string s, int i, int j) {
        while (i >= 0 && j < s.length() && s[i] == s[j]) {
            int currLen = j - i + 1;  // Current palindrome length
            if (currLen > maxLen) {
                res = s.substr(i, currLen);  // Update result if longer palindrome found
                maxLen = currLen;  // Update maxLen
            }
            i--;  // Expand left
            j++;  // Expand right
        }
    }

public:
    string longestPalindrome(string s) {
        int n = s.length();
        if (n < 2) return s;  // Return s if it has 0 or 1 character

        // Iterate through each character as a potential center of palindrome
        for (int i = 0; i < n; i++) {
            findPalindrome(s, i, i);      // Odd-length palindromes
            findPalindrome(s, i, i + 1);  // Even-length palindromes
        }

        return res;  // Return the longest palindromic substring
    }
};
