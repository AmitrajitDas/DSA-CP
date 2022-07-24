class Solution {
public:
    
     bool isPal(string s, int start, int end) {
        while (start <= end) {
          if (s[start++] != s[end--])
            return false;
        }
        return true;
    }
    
    void genPal(int ind, string s, vector<string> &path, vector<vector<string>> &res) {
        
        if (ind == s.size()) {
          res.push_back(path);
          return;
        }
        
        for(int i = ind; i < s.size(); i++) {
            if(isPal(s, ind, i)) {
                path.push_back(s.substr(ind, i - ind + 1));
                genPal(i + 1, s, path, res);
                path.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        vector<string> path;
        vector<vector<string>> res;
        genPal(0, s, path, res);
        return res;
        
    }
};