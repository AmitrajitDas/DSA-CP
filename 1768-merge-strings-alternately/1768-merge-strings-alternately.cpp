class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int i = 0, j = 0;
        string res;
        while(i < word1.size() && j < word2.size()) {
            res = res + word1[i++] + word2[j++]; 
        }
        while(i < word1.size()) {
            res += word1[i++];
        }
        while(j < word2.size()) {
            res += word2[j++];
        }

        return res;
    }
};