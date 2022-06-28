class Solution {
public:
    int minDeletions(string s) {
        
        vector<int> freq(26, 0);
        
        for(char &it : s) freq[it - 'a']++;
        
        sort(freq.begin(), freq.end(), greater<int>());
        
        int f = freq[0];
        int res = 0;
        
        for(int &it : freq) {
            
            if(it > f) {
                if(f > 0) res += it - f;
                else res += it;
            }
            
            f = min(it - 1, f - 1);
        }
        
        return res;
    }
};