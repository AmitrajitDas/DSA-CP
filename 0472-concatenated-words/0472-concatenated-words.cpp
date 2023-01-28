class Solution {
private:
    bool isConcat(string word, unordered_set<string> &st, unordered_map<string, bool> &vis) {
        if(vis.find(word) != vis.end()) return vis[word]; // memoization

        for(int i = 0; i < word.size(); i++) {
            string prefix = word.substr(0, i + 1);
            string suffix = word.substr(i + 1);
            
            // checking if prefix and suffix exist and breaking the suffix further if it's not found
            if((st.find(prefix) != st.end() && st.find(suffix) != st.end()) || (st.find(prefix) != st.end() && isConcat(suffix, st, vis)))
                return vis[word] = true;
        }

        return vis[word] = false;
    }
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        int n = words.size();
        unordered_set<string> st(words.begin(), words.end());
        unordered_map<string, bool> vis;
        vector<string> res;
        for(int i = 0; i < n; i++) {
            if(isConcat(words[i], st, vis)) res.push_back(words[i]);
        }

        return res;
    }
};