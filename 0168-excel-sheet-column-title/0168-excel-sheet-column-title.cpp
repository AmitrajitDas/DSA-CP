class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res;
        while(columnNumber > 0) {
            columnNumber--; // Convert to 0-based index (Excel column titles are 1-based).
            int rem = columnNumber % 26; // Calculate the remainder when dividing by 26.
            res += rem + 'A'; // Convert remainder to character and append to result string.
            columnNumber /= 26; // Divide columnNumber by 26 to move to the next digit.
        }

        reverse(res.begin(), res.end()); // Reverse the result to get the correct order.
        return res;
    }
};
