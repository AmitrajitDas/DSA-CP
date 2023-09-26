class Solution {
public:
    string removeDuplicateLetters(string s) {
        int n = s.size();
        vector<bool> taken(26, false);
        vector<int> lastIdx(26);
        string res;

        for (int i = 0; i < n; i++) lastIdx[s[i] - 'a'] = i;
        for (int i = 0; i < n; i++) {
            int idx = s[i] - 'a';
            if (taken[idx]) continue;
            while (!res.empty() && res.back() > s[i] && lastIdx[res.back() - 'a'] > i) {
                taken[res.back() - 'a'] = false;
                res.pop_back();
            }

            res += s[i];
            taken[idx] = true;
        }

        return res;
    }
};
