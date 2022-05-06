class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        unordered_map<int, int> map;
        vector<int> res;
        for(int it : nums) map[it]++;
        
        for(auto it : map) {
            if(it.second == 2) res.push_back(it.first);
        }
        
        return res;
    }
};