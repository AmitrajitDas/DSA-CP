class Solution {
public:
    int compress(vector<char>& chars) {
        int n = chars.size();
        int i = 0, j = 0;

        while(j < n) {
            char curr_char = chars[j];
            int count = 0;
            while(j < n && chars[j] == curr_char) { // this will track character count
                j++;
                count++;
            }
            chars[i++] = curr_char; // assigning characters
            if(count > 1) {
                string countStr = to_string(count);
                // this loop will take care for double digit numbers
                for(char ch : countStr) {
                    chars[i++] = ch; // assigning character count as string
                }
            }
        }

        return i; // i will be at the next index of the last character of modified array, so i will be the length
    }
};