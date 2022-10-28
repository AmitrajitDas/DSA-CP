class Solution{
public:
    int lengthOfLongestSubstring(string s) {
        int i = 0, j = 0, n = s.length(), len = 0;
        unordered_set<char> st;

        while (j < n) {
            if (st.find(s[j]) == st.end()) {
                st.insert(s[j++]);
                len = max((int)st.size(), len);
            }
            else st.erase(s[i++]);
        }

        return len;
    }
};