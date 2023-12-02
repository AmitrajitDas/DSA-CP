class Solution {
private:
    bool canForm(const string& word, vector<int>& counts) {
        vector<int> c(26, 0);

        // Update counts array
        for (char ch : word) {
            int x = ch - 'a';
            c[x]++;
            if (c[x] > counts[x]) return false;
        }
        return true;
    }
public:
    int countCharacters(vector<string>& words, string chars) {
        vector<int> counts(26, 0);

        // Initialize character counts array
        for (char ch : chars) counts[ch - 'a']++;

        int result = 0;

        // Check words
        for (const string& word : words) {
            if (canForm(word, counts)) {
                // Calculate lengths
                result += word.length();
            }
        }

        return result;
    }
};