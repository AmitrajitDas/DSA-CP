class Solution {
public:
    
    static bool comp(pair<int, int> a, pair<int, int> b) {
        
        if(a.second == b.second)
            return a.first > b.first;
            
        return a.second > b.second;
    }
    
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        map<int, int> map;
        vector<int> res;
        
        for(int i = 0; i < nums.size(); i++) {
            
            if (map.find(nums[i]) == map.end())
                map[nums[i]] = 1;
            else
                map[nums[i]]++;
        }
        
        vector<pair<int, int>> freq(map.begin(), map.end());
        
        sort(freq.begin(), freq.end(), comp);
            
        for(int i = 0; i < k; i++)
            res.push_back(freq[i].first);
        
        return res.size() == 0 ? nums : res;
    }
};