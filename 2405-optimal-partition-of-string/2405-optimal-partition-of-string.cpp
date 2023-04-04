class Solution {
public:
    int partitionString(string s) {
        vector<int> vis(26, -1);
        int count = 0;
        int start = 0; // to keep track of substrings
        for (int i = 0; i < s.length(); i++) {
            // if the current character was seen already in the current substring
            if (vis[s[i] - 'a'] >= start) { 
                count++;
                start = i;
            }
            vis[s[i] - 'a'] = i;
        }

        return count+1;
    }
};