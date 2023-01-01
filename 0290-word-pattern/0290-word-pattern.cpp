class Solution {
public:
    bool wordPattern(string pattern, string s) {
        stringstream ss(s);
        string word = "";
        unordered_map<char, string> char2str;
        unordered_map<string, char> str2char;

        for(auto it : pattern) {
            ss >> word; // reading one string at a time
            if(char2str.find(it) != char2str.end() || str2char.find(word) != str2char.end()) { // mapping check
                if(char2str[it] != word || str2char[word] != it) return false;
            } else {
                char2str[it] = word;
                str2char[word] = it;
            }
        }

        if(ss >> word) return false; // if any string remains
        return true;
    }
};