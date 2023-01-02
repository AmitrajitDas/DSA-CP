class Solution {
public:
    bool detectCapitalUse(string word) {
        int n = word.size();
        int upper = 0;
        for(auto &it : word) {
            if(it >= 'A' && it <= 'Z') upper++;
        }
        if(upper == 0 || upper == n) return true;
        else if(upper == 1 && word[0] >= 'A' && word[0] <= 'Z') return true;
        return false;
    }
};