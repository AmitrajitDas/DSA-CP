class Solution {
public:
    string reverseWords(string s) {
        
        int i = 0, n = s.size();
        string res = "";
        
        while(i < n) {
            while(i < n && s[i] == ' ') i++; // skip spaces
            if(i >= n) break;
            int j = i + 1; // j will start immediately after i
            while( j < n && s[j] != ' ') j++; // skip non-spaces
            string str = s.substr(i, j - i);
            if(res.size() == 0) res = str;
            else res = str + " " + res;
            i = j + 1;
        }
        
        return res;
    }
};