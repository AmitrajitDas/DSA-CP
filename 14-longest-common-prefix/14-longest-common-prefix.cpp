class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n = strs.size();
        sort(strs.begin(), strs.end());
        
        string start = strs[0], end = strs[n - 1]; // start and end strings will be the least matched so if we compare them only we can the LCP
        int i = 0;
        while(i < start.length() && start[i] == end[i]) {
            i++;
        }
        
        return i == 0 ? "" : start.substr(0, i);
    }
};
