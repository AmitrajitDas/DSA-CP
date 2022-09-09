class Solution {
public:
    
    static bool comp(vector<int> &a, vector<int> &b) {
        return a[0] == b[0] ? a[1] > b[1] : a[0] < b[0];
    }
    
    int numberOfWeakCharacters(vector<vector<int>> &properties) {
        int n = properties.size();
        sort(properties.begin(), properties.end(), comp);
        int maxTillNow = INT_MIN;
        int res = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            if(properties[i][1] < maxTillNow) res++;
            maxTillNow = max(properties[i][1], maxTillNow);
        }
        
        return res;
    }
};