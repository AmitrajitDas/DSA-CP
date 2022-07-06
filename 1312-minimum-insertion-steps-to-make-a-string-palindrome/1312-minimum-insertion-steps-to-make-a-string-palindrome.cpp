class Solution {
public:
    int minInsertions(string s) {
         
        int n = s.size();
        string rev = string(s.rbegin(), s.rend());
        
        vector<int> prev(n + 1, 0), curr(n + 1, 0);
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s[i - 1] == rev[j - 1]) curr[j] = 1 + prev[j - 1];
                else curr[j] = max(prev[j], curr[j - 1]);
            }
            
            prev = curr;
        }
        
        int res = n - prev[n]; // string length - LPS of that string yields min insertion steps
        
        return res;
    }
};