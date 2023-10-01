class Solution {
public:
    string reverseWords(string s) {
        string word, res;
        istringstream stream(s);       // Create a string stream to read words from the input string.

        while (stream >> word) {       // Read words from the string stream one by one.
            reverse(word.begin(), word.end()); // Reverse the characters in the current word.
            res += word + " ";         // Append the reversed word followed by a space to the result.
        }

        if (!res.empty()) res.pop_back();  // Remove the trailing space if the result is not empty.
        return res;
    }
};