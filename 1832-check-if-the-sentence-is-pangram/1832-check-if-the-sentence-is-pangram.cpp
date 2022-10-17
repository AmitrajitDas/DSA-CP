class Solution {
public:
    bool checkIfPangram(string sentence) {
        unordered_set<int> s;
        for(char c : sentence) s.insert(c - '0');
        return s.size() == 26;
    }
};