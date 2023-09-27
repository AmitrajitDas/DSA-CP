class Solution {
    typedef long long ll;
public:
    string decodeAtIndex(string s, int k) {
        int n = s.size();
        ll size = 0; // Initialize a variable to keep track of the size of the decoded string.

        // Calculate the size of the decoded string by iterating through the characters in the input string.
        for (char ch : s) {
            if (isdigit(ch)) {
                // If the character is a digit, multiply the current size by the digit's value.
                size *= (ch - '0');
            } else {
                // If the character is an alphabet character, increment the size by 1.
                size++;
            }
        }

        // Traverse the input string in reverse order to find the kth character.
        for (int i = n - 1; i >= 0; i--) {
            k %= size; // Take the modulo of k with the current size.

            // If k becomes 0 and the current character is an alphabet character, return it.
            if (k == 0 && isalpha(s[i])) {
                return string(1, s[i]); // Convert the character to a string and return it.
            } else if (isalpha(s[i])) {
                // If the current character is an alphabet character (not a digit), decrement the size by 1.
                size--;
            } else {
                // If the current character is a digit, divide the size by the digit's value.
                size /= (s[i] - '0');
            }
        }

        return ""; // If kth character is not found, return an empty string.
    }
};
