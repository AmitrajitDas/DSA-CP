class Solution {
public:
    int characterReplacement(string s, int k) {
        int i = 0, n = s.size(), res = 0, maxCount = 0;
        vector<int> charCount(26, 0);
        for(int j = 0; j < n; j++) {
            charCount[s[j] - 'A']++;
            maxCount = max(charCount[s[j] - 'A'], maxCount);
            // window size - maxCount yields minCount which should be greater than k to shift the window
            while(j - i - maxCount + 1 > k) { 
                charCount[s[i] - 'A']--;
                i++;
            }
            res = max(j - i + 1, res);
        }

        return res;
    }
};