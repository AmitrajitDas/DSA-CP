class Solution {
public:
    int minSetSize(vector<int>& arr) {
        unordered_map<int, int> map;
        for (int it : arr) map[it]++;
        
        vector<int> freq;
        for (auto [_, fr] : map) freq.push_back(fr);
        sort(freq.begin(), freq.end());
        
        int res = 0, removed = 0; 
        int i = freq.size() - 1, half = arr.size()/2;
        
        while(removed < half) {
            res++;
            removed += freq[i--];
        }
        
        return res;
    }
};